package self.project.oneulmal.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import self.project.oneulmal.security.login.JsonUsernamePasswordAuthenticationFilter;
import self.project.oneulmal.security.oauth.PrincipalOAuth2UserService;

@Component
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PrincipalOAuth2UserService principalOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/api")
                .permitAll()
                .and()
                .formLogin()
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(principalOAuth2UserService);

        http.addFilterBefore(getJsonUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    protected JsonUsernamePasswordAuthenticationFilter getJsonUsernamePasswordAuthenticationFilter() throws Exception {
        JsonUsernamePasswordAuthenticationFilter filter = new JsonUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }

}
