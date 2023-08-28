package com.example.creditcard.controller;

import com.example.creditcard.model.User;
import com.example.creditcard.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/userRegister")
    private ResponseEntity<?> register(@RequestBody User user) {
        HashMap<String, String> res = new HashMap<>();
        try {
            if (user.getEmail().equals("") && user.getName().equals("") && user.getPassword().equals("")) {
                res.put("msg", "Please fill all the fields");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            }
            boolean checkUser = userService.getByEmail(user.getEmail()) != null;
            if (checkUser) {
                res.put("msg", "Student already exists");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            } else {
                userService.add(user);
//                userService.sendEmail(user.getEmail(),
//                        "Login credentials",
//                        "Congratulations !!! You are successfully registered Your login credentials  are " +
//                                "  Email : " + user.getEmail() +"" + "Password  : " + user.getPassword());
//                res.put("msg", "Student added successfully");
                return new ResponseEntity<>(res, HttpStatus.OK);
            }
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/userLogin")
    private ResponseEntity<?> login(@RequestBody User user) {
        HashMap<String, String> res = new HashMap<>();
        try {
            if (user.getEmail().equals("") && user.getPassword().equals("")) {
                res.put("msg", "please fill all the fields");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            }
            User checkUser = userService.getByEmail(user.getEmail());
            if (checkUser == null) {
                res.put("msg", "User not found");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            } else if(checkUser.getPassword().equals(user.getPassword())) {
                res.put("msg", "user login successfully");
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


    @GetMapping("/user")
    private ResponseEntity<?> all() {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(userService.all(), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/userByEmail/{email}")
    private ResponseEntity<?> getByEmail(@PathVariable String email) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(userService.getByEmail(email), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/user")
    private ResponseEntity<?> addUser(@RequestBody User user) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(userService.add(user), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/user/{id}")
    private ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            User u = userService.getById(id);
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
            if (user.getPhoneNumber() != null) {
                u.setPhoneNumber(user.getPhoneNumber());
            } else {
                u.setPhoneNumber(u.getPhoneNumber());
            } if (user.getAddress() != null) {
                u.setAddress(user.getAddress());
            } else {
                u.setAddress(u.getAddress());
            }
            return new ResponseEntity<>(userService.update(u), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/user/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            userService.delete(id);
            res.put("msg", "User deleted successfully");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
