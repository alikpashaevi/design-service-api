package alik.designservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnswerRequest {
    private String email;
    private String answerValue;
    private Long questionId;
}
