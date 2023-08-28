package com.example.creditcard.controller;

import com.example.creditcard.model.CreditCardPartner;
import com.example.creditcard.model.User;
import com.example.creditcard.service.ICreditCardPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class CreditCardPartnerController {
    @Autowired
    private ICreditCardPartnerService cardPartnerService;

    @GetMapping("/partner")
    private ResponseEntity<?> all() {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(cardPartnerService.all(), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/partner/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(cardPartnerService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/partnerByEmail/{email}")
    private ResponseEntity<?> getByEmail(@PathVariable String email) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(cardPartnerService.getByEmail(email), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/partner")
    private ResponseEntity<?> addUser(@RequestBody CreditCardPartner user) {
        HashMap<String, String> res = new HashMap<>();
        try {
            int count = 0;

            return new ResponseEntity<>(cardPartnerService.add(user), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/partner/{id}")
    private ResponseEntity<?> updateUser(@RequestBody CreditCardPartner user, @PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            CreditCardPartner u = cardPartnerService.getById(id);
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
            if(u.getBankEmail() !=null){
                u.setBankEmail(user.getBankEmail());
            }else{
                u.setBankEmail(user.getBankEmail());
            }
            return new ResponseEntity<>(cardPartnerService.update(u), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/partner/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            cardPartnerService.delete(id);
            res.put("msg", "User deleted successfully");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/partnerLogin")
    private ResponseEntity<?> login(@RequestBody CreditCardPartner user) {
        HashMap<String, String> res = new HashMap<>();
        try {

            if (user.getEmail().equals("") && user.getPassword().equals("")) {
                res.put("msg", "please fill all the fields");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            }
            CreditCardPartner checkUser = cardPartnerService.getByEmail(user.getEmail());
            if (checkUser == null) {
                res.put("msg", "Partner not found");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            } else if(checkUser.getPassword().equals(user.getPassword())) {

                res.put("msg", "Partner login successfully");
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

    @PostMapping("/partnerRegister")
    private ResponseEntity<?> register(@RequestBody CreditCardPartner user) {
        HashMap<String, String> res = new HashMap<>();
        try {
            if (user.getEmail().equals("") && user.getName().equals("") && user.getPassword().equals("")) {
                res.put("msg", "Please fill all the fields");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            }
            boolean checkUser = cardPartnerService.getByEmail(user.getEmail()) != null;
            if (checkUser) {
                res.put("msg", "Partner already exists");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            } else {
                cardPartnerService.add(user);
                res.put("msg", "Partner added successfully");
                return new ResponseEntity<>(res, HttpStatus.OK);
            }
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
