package com.example.creditcard.service.impl;

import com.example.creditcard.model.Question;
import com.example.creditcard.repository.IQuestionRepository;
import com.example.creditcard.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private IQuestionRepository questionRepository;

    @Override
    public List<Question> all() {
        return questionRepository.findAll();
    }

    @Override
    public Question getById(Long id) {
        return questionRepository.findById(id).get();
    }

    @Override
    public Question add(Question faculty) {
        return questionRepository.save(faculty);
    }

    @Override
    public Question update(Question faculty) {
        return questionRepository.save(faculty);
    }

    @Override
    public void delete(Long id) {
        questionRepository.deleteById(id);
    }
}

