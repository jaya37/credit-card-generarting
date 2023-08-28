package com.example.creditcard.service.impl;

import com.example.creditcard.model.User;
import com.example.creditcard.repository.IUserRepository;
import com.example.creditcard.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom("cse.takeoff@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);

    }
    @Override
    public List<User> all() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User add(User faculty) {
        return userRepository.save(faculty);
    }

    @Override
    public User update(User faculty) {
        return userRepository.save(faculty);
    }

    @Override
    public void delete(Long id) {
            userRepository.deleteById(id);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }



}
