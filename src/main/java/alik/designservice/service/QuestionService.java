package alik.designservice.service;

import alik.designservice.dto.QuestionRequest;
import alik.designservice.model.Question;
import alik.designservice.repository.QuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepo questionRepo;

    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    public List<Question> getQuestionByType(String type) {
        return questionRepo.findByType(type);
    }

    public void createQuestion(QuestionRequest request) {
        Question question = new Question();
        question.setQuestion(request.getQuestion());
        question.setType(request.getType());
        questionRepo.save(question);
    }

    public void editQuestion(long id, QuestionRequest request) {
        Question question = questionRepo.findById(id).get();
        question.setQuestion(request.getQuestion());
        question.setType(request.getType());
        questionRepo.save(question);
    }

    public void deleteQuestion(long id) {
        questionRepo.deleteById(id);
    }

}
