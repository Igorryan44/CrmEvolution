package igor_dev.CrmEvolution.model;

import igor_dev.CrmEvolution.enums.UserAccess;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String nickname;

    @Column(unique = true)
    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private UserAccess access;

    public User() {
    }

    public User(Long id, String name, String nickname, String email, String senha, UserAccess access) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.senha = senha;
        this.access = access;
    }

    /// Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAccess(UserAccess access) {
        this.access = access;
    }

    /// Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public UserAccess getAccess() {
        return access;
    }
}
