package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {

    @Autowired
    private QuestionRepo questionRepo;

    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            List<Question> questionList = new ArrayList<>(questionRepo.findAll());

            if (questionList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(questionList, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getQuestionById/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Optional<Question> questionData = questionRepo.findById(id);

        if (questionData.isPresent()) {
            return new ResponseEntity<>(questionData.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        Question questionObj = questionRepo.save(question);

        return new ResponseEntity<>(questionObj, HttpStatus.OK);
    }

    @PostMapping("/updateQuestionById/{id}")
    public ResponseEntity<Question> updateQuestionById(@PathVariable Long id, @RequestBody Question newQuestionData) {
        Optional<Question> oldQuestionData = questionRepo.findById(id);

        if (oldQuestionData.isPresent()) {
           Question updatedQuestionData = oldQuestionData.get();
           updatedQuestionData.setBody(newQuestionData.getBody());
           updatedQuestionData.setCategory(newQuestionData.getCategory());
           updatedQuestionData.setDifficultyLevel(newQuestionData.getDifficultyLevel());
           updatedQuestionData.setAuthor(newQuestionData.getAuthor());

           Question questionObj = questionRepo.save(updatedQuestionData);
           return new ResponseEntity<>(questionObj, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteQuestionById/{id}")
    public ResponseEntity<HttpStatus> deleteQuestionById(@PathVariable Long id) {
        questionRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
