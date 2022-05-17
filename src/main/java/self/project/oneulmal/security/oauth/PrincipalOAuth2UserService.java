package self.project.oneulmal.security.oauth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import self.project.oneulmal.security.PrincipalDetails;
import self.project.oneulmal.security.oauth.provider.GoogleUserInfo;
import self.project.oneulmal.security.oauth.provider.NaverUserInfo;
import self.project.oneulmal.security.oauth.provider.OAuth2UserInfo;
import self.project.oneulmal.user.domain.User;
import self.project.oneulmal.user.domain.UserRepository;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    private OAuth2UserInfo oAuth2UserInfo;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        String name = oAuth2User.getAttribute("name");
        String email = oAuth2User.getAttribute("email");

        if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        } else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
            oAuth2UserInfo = new NaverUserInfo((Map<String, Object>) oAuth2User.getAttributes().get("response"));
        }

        User user = User.builder()
                .name(oAuth2UserInfo.getName())
                .email(oAuth2UserInfo.getEmail())
                .provider(oAuth2UserInfo.getProvider())
                .build();

        userRepository.save(user);

        return new PrincipalDetails(user, oAuth2User.getAttributes());
    }
}
