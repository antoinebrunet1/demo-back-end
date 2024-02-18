package com.example.demo.repository;

import com.example.demo.model.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
    @Override
    List<Question> findAll();
}
