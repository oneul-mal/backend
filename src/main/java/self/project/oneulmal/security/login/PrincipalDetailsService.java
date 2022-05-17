package self.project.oneulmal.security.login;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import self.project.oneulmal.security.PrincipalDetails;
import self.project.oneulmal.user.domain.User;
import self.project.oneulmal.user.domain.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByName(username);
        return optionalUser.map(PrincipalDetails::new).orElse(null);
    }

}
