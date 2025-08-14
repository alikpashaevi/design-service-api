package alik.designservice.controllers;


import alik.designservice.dto.QuestionRequest;
import alik.designservice.model.Question;
import alik.designservice.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/get-by-type")
    public List<Question> getQuestionsByType(@RequestParam String type) {
        return questionService.getQuestionByType(type);
    }

    @PostMapping
    public ResponseEntity<Void> createQuestion(@RequestBody QuestionRequest request) {
        questionService.createQuestion(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateQuestion(@PathVariable long id, @RequestBody QuestionRequest request) {
        questionService.editQuestion(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable long id) {
        questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
