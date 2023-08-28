package com.example.creditcard.controller;

import com.example.creditcard.model.Question;
import com.example.creditcard.model.User;
import com.example.creditcard.service.IQuestionService;
import com.example.creditcard.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;
    @Autowired
    private IUserService userService;

    @GetMapping("/question")
    private ResponseEntity<?> all() {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(questionService.all(), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/question/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(questionService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/question")
    private ResponseEntity<?> addUser(@RequestBody Question user) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(questionService.add(user), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addQuestion/{id}/{uId}")
    private ResponseEntity<?> add(@PathVariable Long id,@PathVariable Long uId) {
        HashMap<String, String> res = new HashMap<>();
        try {
            Question question=questionService.getById(id);
            User user=userService.getById(uId);
            user.getQuestions().add(question);
            return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PatchMapping("/question/{id}")
    private ResponseEntity<?> updateUser(@RequestBody Question user, @PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            Question u = questionService.getById(id);
            if (user.getQuestion()  != null) {
                u.setQuestion(user.getQuestion());
            } else {
                u.setQuestion(u.getQuestion());
            }
            if (user.getAnswer() != null) {
                u.setAnswer(user.getAnswer());
            } else {
                u.setAnswer(u.getAnswer());
            }
            if (user.getUserEmail() != null) {
                u.setUserEmail(user.getUserEmail());
            } else {
                u.setUserEmail(u.getUserEmail());
            }

            return new ResponseEntity<>(questionService.update(u), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/question/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            questionService.delete(id);
            res.put("msg", "Question deleted successfully");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
