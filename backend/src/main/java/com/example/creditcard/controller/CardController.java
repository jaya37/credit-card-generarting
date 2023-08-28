package com.example.creditcard.controller;

import com.example.creditcard.model.Card;
import com.example.creditcard.model.User;
import com.example.creditcard.service.ICardService;
import com.example.creditcard.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class CardController {

    @Autowired
    private ICardService cardService;
    @Autowired
    private IUserService userService;

    @GetMapping("/card/{id}")
    private ResponseEntity<?> getByEmail(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            User user = userService.getById(id);
            return new ResponseEntity<>(user.getCards(), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        @GetMapping("/cardByName/{name}")
    private ResponseEntity<?> cardByName(@PathVariable String name) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(cardService.getByUserName(name), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/card")
    private ResponseEntity<?> addUser(@RequestBody Card user) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(cardService.add(user), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/card/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            cardService.delete(id);
            res.put("msg", "User deleted successfully");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
