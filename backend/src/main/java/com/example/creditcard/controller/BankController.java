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

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class BankController {
    @Autowired
    private IBankService bankService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserService userService;



    @PostMapping("/accountRequest/{id}")
    private ResponseEntity<?> update(@PathVariable Long id,@RequestBody Account request) {
        HashMap<String, String> res = new HashMap<>();
        try {
            String abc="accepted";
            AccountRequest accountRequest=accountService.getRequest(id);
            accountRequest.setStatus(abc);
            accountService.updateRequest(accountRequest);

            //Creating account for user after accepting Bank
            Account account=new Account();
            account.setUserName(accountRequest.getName());
            account.setBankName(request.getBankName());
            account.setAddress(request.getAddress());
            account.setBankEmail(request.getBankEmail());
            account.setEmail(accountRequest.getEmail());
            account.setBranch(request.getBranch());
            account.setCifCode(request.getCifCode());
            account.setIfscCode(request.getIfscCode());
            accountService.update(account);

            //account adding to the requested user
            User user=userService.getByEmail(accountRequest.getEmail());
            Bank bank=bankService.getByEmail(accountRequest.getBankEmail());
            if(user.getBanks().contains(bank)){
                return new ResponseEntity<>("Account already exists",HttpStatus.BAD_GATEWAY);
            }else{
                user.getBanks().add(bank);
                user.setAccount(account);
                userService.update(user);
            }


            // These accept info send to the user by email
//            userService.sendEmail(user.getEmail(),
//                     "Request Accepted by" + request.getBankName() ,
//                    "Congratulations !!! Your Account is created please check your account details " +
//                            "  Email : " + user.getEmail() +"\n" + "Password  : " + user.getPassword()) ;
            return new ResponseEntity<>(accountService.update(account), HttpStatus.OK);


        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/rejectRequest/{id}")
    private ResponseEntity<?> rejectRequest(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            AccountRequest request= accountService.getRequest(id);
            request.setStatus("Rejected");
            return new ResponseEntity<>(accountService.updateRequest(request), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/userRequests/{id}")
    private ResponseEntity<?> userRequests(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            Bank bank=bankService.getById(id);
            return new ResponseEntity<>(bank.getAccountRequests(), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/bank")
    private ResponseEntity<?> getAll() {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(bankService.all(), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bank/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(bankService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bankByEmail/{email}")
    private ResponseEntity<?> getByEmail(@PathVariable String email) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(bankService.getByEmail(email), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/bank")
    private ResponseEntity<?> addUser(@RequestBody Bank user) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(bankService.add(user), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/bank/{id}")
    private ResponseEntity<?> updateUser(@RequestBody Bank user, @PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            Bank u = bankService.getById(id);
            u.setStatus("updated");
            if (user.getName() != null) {
                u.setName(user.getName());
            } else {
                u.setName(u.getName());
            }
            if (user.getEmail() != null) {
                u.setEmail(user.getEmail());
            } else {
                u.setEmail(u.getEmail());
            }
            if (user.getPassword() != null) {
                u.setPassword(user.getPassword());
            } else {
                u.setPassword(u.getPassword());
            }
            if (user.getAddress() != null) {
                u.setAddress(user.getAddress());
            } else {
                u.setAddress(u.getAddress());
            }
            if (user.getPhoneNumber() != null) {
                u.setPhoneNumber(user.getPhoneNumber());
            } else {
                u.setPhoneNumber(u.getPhoneNumber());
            }
            if (user.getIfscCode() != null) {
                u.setIfscCode(user.getIfscCode());
            } else {
                u.setIfscCode(u.getIfscCode());
            }
            if (user.getCifCode() != null) {
                u.setCifCode(user.getCifCode());
            } else {
                u.setCifCode(u.getCifCode());
            }
            if (user.getBranch() != null) {
                u.setBranch(user.getBranch());
            } else {
                u.setBranch(u.getBranch());
            }
            return new ResponseEntity<>(bankService.update(u), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/bank/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            bankService.delete(id);
            res.put("msg", "User deleted successfully");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/bankLogin")
    private ResponseEntity<?> login(@RequestBody Bank user) {
        HashMap<String, String> res = new HashMap<>();
        try {

            if (user.getEmail().equals("") && user.getPassword().equals("")) {
                res.put("msg", "please fill all the fields");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            }
            Bank checkUser = bankService.getByEmail(user.getEmail());
            if (checkUser == null) {
                res.put("msg", "Bank not found");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            } else if(checkUser.getPassword().equals(user.getPassword())) {

                res.put("msg", "Bank login successfully");
                return new ResponseEntity<>(checkUser, HttpStatus.OK);
            } else {
                res.put("msg", "Password not matched");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/bankRegister")
    private ResponseEntity<?> register(@RequestBody Bank user) {
        HashMap<String, String> res = new HashMap<>();
        try {
            if (user.getEmail().equals("") && user.getName().equals("") && user.getPassword().equals("")) {
                res.put("msg", "Please fill all the fields");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            }
            boolean checkUser = bankService.getByEmail(user.getEmail()) != null;
            if (checkUser) {
                res.put("msg", "Bank already exists");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            } else {
                bankService.add(user);
                res.put("msg", "Bank added successfully");
                return new ResponseEntity<>(res, HttpStatus.OK);
            }
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
