package alik.designservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "answer")
@SequenceGenerator(name = "answer_seq_gen", sequenceName = "answer_seq", allocationSize = 1)
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(generator = "answer_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "answerValue")
    private String answerValue;

    @ManyToOne
    private Question question;
}

