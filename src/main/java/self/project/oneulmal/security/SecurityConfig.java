package self.project.oneulmal.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import self.project.oneulmal.security.login.JsonUsernamePasswordAuthenticationFilter;

@Component
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/api")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/api/user/login")
                .loginProcessingUrl("/api/user/login");

        http.addFilterBefore(getJsonUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    protected JsonUsernamePasswordAuthenticationFilter getJsonUsernamePasswordAuthenticationFilter() throws Exception {
        JsonUsernamePasswordAuthenticationFilter filter = new JsonUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }

    // TODO 
    // 어 json으로 받아서 로그인하는 것 해야되는데
    // 그전에 회원가입 로직부터 만들고
    // 로그인 진행하자
}
