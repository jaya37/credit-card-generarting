package com.example.creditcard.service;

import com.example.creditcard.model.Question;
import com.example.creditcard.model.User;

import java.util.List;

public interface IQuestionService {

    List<Question> all();
    Question getById(Long id);
    Question add(Question faculty);
    Question update(Question faculty);
    void delete(Long id);
}
