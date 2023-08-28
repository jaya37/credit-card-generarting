package com.example.creditcard.controller;

import com.example.creditcard.model.Account;
import com.example.creditcard.model.AccountRequest;

import com.example.creditcard.model.Bank;
import com.example.creditcard.model.User;
import com.example.creditcard.service.IAccountService;
import com.example.creditcard.service.IBankService;
import com.example.creditcard.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IBankService bankService;

    @GetMapping("/account")
    private ResponseEntity<?> all() {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(accountService.all(), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/account/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(accountService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/myAccount/{email}")
    private ResponseEntity<?> myAccount(@PathVariable String email) {
        HashMap<String, String> res = new HashMap<>();
        try {
            List<Account>accounts= accountService.getByEmail(email);
            return new ResponseEntity<>(accounts, HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/account")
    private ResponseEntity<?> addUser(@RequestBody Account user) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(accountService.add(user), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/account/{uId}/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable Long uId,@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            User user=userService.getById(uId);
            user.setAccount(null);
            userService.update(user);
            accountService.delete(id);
            res.put("msg", "Account deleted successfully");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/accountRequest")
    private ResponseEntity<?> allRequests() {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(accountService.allRequests(), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/userRequest/{email}")
    private ResponseEntity<?> userRequest(@PathVariable String email) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(accountService.allRequests().stream().filter(i->i.getEmail().equals(email)), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/accountRequest/{id}")
    private ResponseEntity<?> getRequest(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(accountService.getRequest(id), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/userAccountRequest/{id}/{uId}")
    private ResponseEntity<?> addRequest(@RequestBody AccountRequest user,@PathVariable Long id,@PathVariable Long uId) {
        HashMap<String, String> res = new HashMap<>();
        try {
            Bank bank=bankService.getById(id);
            User user1=userService.getById(uId);

            if (bank.getStatus().equals("created")){
                res.put("msg","Bank need to update profile");
                return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
            }
            if(user1.getBanks().contains(bank)){
                res.put("msg","Already have an account in this bank");
                return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
            }
            if(bank.getAccountRequests().stream().anyMatch(i->i.getEmail().equals(user1.getEmail()))){
                res.put("msg","Request sent already");
                return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
            }
                return new ResponseEntity<>(accountService.addRequest(user), HttpStatus.OK);

        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/addAccountRequest/{id}/{rId}")
    private ResponseEntity<?> addAccountRequest(@PathVariable Long id,@PathVariable Long rId) {
        HashMap<String, String> res = new HashMap<>();
        try {
            Bank user=bankService.getById(id);
            AccountRequest request= accountService.getRequest(rId);
            user.getAccountRequests().add(request);
            bankService.update(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/accountRequest/{id}/{bId}")
    private ResponseEntity<?> deleteRequest(@PathVariable Long id,@PathVariable Long bId) {
        HashMap<String, String> res = new HashMap<>();
        try {
            Bank bank=bankService.getById(bId);
            AccountRequest request= accountService.getRequest(id);
            bank.getAccountRequests().remove(request);
            accountService.deleteRequest(request.getId());
            res.put("msg", "Request deleted successfully");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
