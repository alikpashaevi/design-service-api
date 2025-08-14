package alik.designservice.service;

import alik.designservice.dto.AnswerRequest;
import alik.designservice.model.Answer;
import alik.designservice.repository.AnswerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepo answerRepo;
    private final QuestionService questionService;

    public List<Answer> getAllAnswers() {
        return answerRepo.findAll();
    }

    public List<Answer> getAnswersByQuestionId(long questionId) {
        return answerRepo.findByQuestionId(questionId);
    }

    public List<Answer> getAnswerByUserEmail(String email) {
        return answerRepo.findByEmail(email);
    }

    public void addAnswer(AnswerRequest request) {
        Answer answer = new Answer();
        answer.setEmail(request.getEmail());
        answer.setAnswerValue(request.getAnswerValue());
        answer.setQuestion(questionService.getQuestionById(request.getQuestionId()));
        answerRepo.save(answer);
    }

    public void updateAnswer(long id, AnswerRequest request) {
        Answer answer = answerRepo.findById(id).get();
        answer.setEmail(request.getEmail());
        answer.setAnswerValue(request.getAnswerValue());
        answer.setQuestion(questionService.getQuestionById(request.getQuestionId()));
        answerRepo.save(answer);
    }

    public void deleteAnswer(long id) {
        answerRepo.deleteById(id);
    }


}
