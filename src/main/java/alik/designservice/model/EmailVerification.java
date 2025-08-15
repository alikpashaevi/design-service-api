package alik.designservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "email_verification")
@SequenceGenerator(name = "email_seq_gen", sequenceName = "email_seq", allocationSize = 1)
@Getter
@Setter
public class EmailVerification {
    @Id
    @GeneratedValue(generator = "email_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "code")
    private String code;

    @Column(name = "expiration_time")
    private LocalDateTime expirationTime;

}
