package alik.designservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "app_user", schema = "design")
@SequenceGenerator(name = "app_user_seq_gen", sequenceName = "user_seq", allocationSize = 1)
public class AdminUser {

    @Id
    @GeneratedValue(generator = "app_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String role;

}
