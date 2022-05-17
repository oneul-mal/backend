package self.project.oneulmal.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String nickname;
    private String email;
    private String provider;
    private String role;

    @Builder
    public User(Long id, String name, String password, String nickname, String email, String provider, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.provider = provider;
        this.role = role;
    }

    public User(String name, String password, String nickname, String email, String provider, String role) {
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.provider = provider;
        this.role = role;
    }
}
