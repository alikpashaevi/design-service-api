package alik.designservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "question")
@SequenceGenerator(name = "question_seq_gen", sequenceName = "question_seq", allocationSize = 1)
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(generator = "question_seq_gen", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "question")
    private String question;

    @Column(name = "type")
    private String type;

}
