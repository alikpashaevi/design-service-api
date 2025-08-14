package alik.designservice.controllers;


import alik.designservice.dto.AnswerRequest;
import alik.designservice.model.Answer;
import alik.designservice.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static alik.designservice.security.AuthorizationConstants.ADMIN;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PreAuthorize(ADMIN)
    @GetMapping
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    @GetMapping("/question/{questionId}")
    public List<Answer> getAnswersByQuestionId(@PathVariable long questionId) {
        return answerService.getAnswersByQuestionId(questionId);
    }

    @GetMapping("/user")
    public List<Answer> getAnswersByEmail(@RequestParam String email) {
        return answerService.getAnswerByUserEmail(email);
    }

    @PostMapping
    public ResponseEntity<String> addAnswer(@RequestBody AnswerRequest request) {
        answerService.addAnswer(request);
        return ResponseEntity.ok("Answer added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAnswer(@PathVariable long id, @RequestBody AnswerRequest request) {
        answerService.updateAnswer(id, request);
        return ResponseEntity.ok("Answer updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnswer(@PathVariable long id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.ok("Answer deleted successfully");
    }
}

