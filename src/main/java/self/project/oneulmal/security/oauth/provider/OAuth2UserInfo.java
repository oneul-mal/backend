package self.project.oneulmal.security.oauth.provider;

public interface OAuth2UserInfo {
    String getProvider();

    String getProviderId();

    String getName();

    String getEmail();

    String getNickname();
}
