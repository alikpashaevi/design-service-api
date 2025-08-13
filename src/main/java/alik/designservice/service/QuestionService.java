package alik.designservice.service;

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

}
