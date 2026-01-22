package igor_dev.CrmEvolution.model;

import igor_dev.CrmEvolution.enums.UserAccess;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String nickname;

    @OneToOne(fetch = FetchType.LAZY)
    private Email email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private UserAccess access;

    @OneToOne(fetch = FetchType.LAZY)
    private Lead lead;
}
