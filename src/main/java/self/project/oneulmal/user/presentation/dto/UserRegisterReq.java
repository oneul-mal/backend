package self.project.oneulmal.user.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import self.project.oneulmal.user.domain.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterReq {
    private String name;
    private String password;
    private String nickname;
    private String email;

    public User toEntity(BCryptPasswordEncoder bCryptPasswordEncoder) {
        return User.builder()
                .name(name)
                .password(bCryptPasswordEncoder.encode(password))
                .nickname(nickname)
                .email(email)
                .build();
    }
}
