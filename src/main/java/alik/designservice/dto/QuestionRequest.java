package alik.designservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionRequest {
    private String question;
    private String type;
}
