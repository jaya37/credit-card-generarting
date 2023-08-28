package com.example.creditcard.controller;

import com.example.creditcard.model.*;
import com.example.creditcard.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class CardRequestController {
    @Autowired
    private ICardRequestService cardRequestService;
    @Autowired
    private ICardService cardService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IBankService bankService;
    @Autowired
    private ICreditCardPartnerService partnerService;


    // Partner can view card requests send by User
    @GetMapping("/cardRequests/{email}")
    private ResponseEntity<?> cardRequests(@PathVariable String email) {
        HashMap<String, String> res = new HashMap<>();
        try {
            List<CardRequest> requests=cardRequestService.all().stream().filter(i->i.getBankEmail().equals(email)).toList();
            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Bank can view card requests send by partner
    @GetMapping("/bankCardRequests/{email}")
    private ResponseEntity<?> bankCardRequests(@PathVariable String email) {
        HashMap<String, String> res = new HashMap<>();
        try {
            List<CardRequest> requests=cardRequestService.all().stream().filter(i->i.getBankEmail().equals(email)).toList();
            return new ResponseEntity<>(requests.stream().filter(i->i.getStatus().equals("sent")), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/cardRequest/{email}/{userEmail}")
    private ResponseEntity<?> addUser(@PathVariable String email,@PathVariable String userEmail,@RequestBody CardRequest user) {
        HashMap<String, String> res = new HashMap<>();
        try {
            CardRequest request=cardRequestService.getByUserEmailAndBankEmail(userEmail,email);
            if(request!=null){
                return new ResponseEntity<>("Request already raised ", HttpStatus.BAD_REQUEST);
            }
            CreditCardPartner partner=partnerService.getByBankEmail(email);
            if(partner!=null){
                return new ResponseEntity<>(cardRequestService.add(user), HttpStatus.OK);
            }else{
                return new ResponseEntity<>("No credit card partners with this bank", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/addCardRequest/{id}/{uId}")
    private ResponseEntity<?> addUser(@PathVariable Long id,@PathVariable Long uId) {
        HashMap<String, String> res = new HashMap<>();
        try {
            User user=userService.getById(id);
            CardRequest request=cardRequestService.getById(uId);
            user.getRequests().add(request);
            return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Here partner to send card request to the bank by using below code

    @PostMapping("/requestToBank/{id}/{email}")
    private ResponseEntity<?> addUse(@PathVariable Long id,@PathVariable String email) {
        HashMap<String, String> res = new HashMap<>();
        try {
            CardRequest request=cardRequestService.getById(id);
            if(request.getStatus().equals("sent")){
                res.put("msg", "Already sent to bank");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            }
            request.setStatus("sent");
            Bank bank=bankService.getByEmail(email);
            bank.getRequests().add(request);
            return new ResponseEntity<>(bankService.update(bank), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Bank accepting the card request sent by partner

    @PostMapping("/bankRequest/{id}")
    private ResponseEntity<?> addUser(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            CardRequest request=cardRequestService.getById(id);
            request.setStatus("accepted by bank");
            return new ResponseEntity<>(cardRequestService.update(request), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Bank reject the card request sent by partner
    @PostMapping("/rejectCard/{id}")
    private ResponseEntity<?> rejectCard(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            CardRequest request=cardRequestService.getById(id);
            request.setStatus("Rejected");
            return new ResponseEntity<>(cardRequestService.update(request), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/acceptCardRequest/{id}")
    private ResponseEntity<?> accept(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            long smallest = 1000_0000_0000_0000L;
            long biggest =  9999_9999_9999_9999L;
            Random rand = new Random();
            // return a long between smallest and biggest (+1 to include biggest as well with the upper bound)
            long random = ThreadLocalRandom.current().nextLong(smallest, biggest+1);
            System.out.println(random);
            String number = String.format("%04d", rand.nextInt(10000));
            System.out.println(number);
            int x = rand.nextInt(900) + 100;
            System.out.println(x);

            //Check and send response for the request
            CardRequest request=cardRequestService.getById(id);
            request.setStatus("accepted");
            cardRequestService.update(request);
            //Generate Expiry date
            int year= YearMonth.now().getYear() + 5;
            System.out.println(year);
            // Card creating for the accepted user
            Card card=new Card();
            card.setUserName(request.getUserName());
            card.setBankName(request.getBankName());
            card.setCardNumber(random);
            card.setExpiryDate(String.valueOf(year));
            card.setPin(Integer.valueOf(number));
            card.setCvv((long) x);
            cardService.update(card);

            // Adding card to the user
            User user=userService.getByEmail(request.getUserEmail());
            user.getCards().add(card);
            user.getAccount().setIsCardGenerated("true");
            userService.update(user);

            return new ResponseEntity<>(cardRequestService.update(request), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/cardRequest")
    private ResponseEntity<?> getById() {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(cardRequestService.all(), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/requests")
    private ResponseEntity<?> AllRequests() {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(cardRequestService.all().stream().filter(i->i.getStatus().equals("requested")), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bankRequests")
    private ResponseEntity<?> bankRequests() {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(cardRequestService.all().stream().filter(i->i.getStatus().equals("accepted by bank")), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/acceptedRequests")
    private ResponseEntity<?> acceptedRequests() {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(cardRequestService.all().stream().filter(i->i.getStatus().equals("accepted")), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/cardRequest/{id}/{uId}")
    private ResponseEntity<?> deleteUser(@PathVariable Long id,@PathVariable Long uId) {
        HashMap<String, String> res = new HashMap<>();
        try {
            User user=userService.getById(uId);
            CardRequest request=cardRequestService.getById(id);
            user.getRequests().remove(request);
            cardRequestService.delete(request.getId());
            userService.update(user);
            res.put("msg", "request deleted successfully");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
