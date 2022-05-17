package self.project.oneulmal.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import self.project.oneulmal.user.domain.User;
import self.project.oneulmal.user.domain.UserRepository;
import self.project.oneulmal.user.presentation.dto.UserAssembler;
import self.project.oneulmal.user.presentation.dto.UserRegisterReq;
import self.project.oneulmal.user.presentation.dto.UserRegisterRes;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRegisterRes save(UserRegisterReq userRegisterReq) {
        User user = userRegisterReq.toEntity(bCryptPasswordEncoder);
        Optional<User> optionalUser = userRepository.findByName(user.getName());
        if (optionalUser.isPresent()) {
            return UserAssembler.userRegisterRes(userRegisterReq);
        }
        userRepository.save(user);
        return UserAssembler.userRegisterRes(userRegisterReq);
    }
}
