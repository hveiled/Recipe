package recipes.security;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(@NotNull AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService) // user store 1
                .passwordEncoder(getEncoder());
    }

    @Override
    protected void configure(@NotNull HttpSecurity http) throws Exception {
        http
                .csrf().disable().headers().frameOptions().disable()
                    .and()
                .httpBasic()
                .and()
                .authorizeRequests()
                    .mvcMatchers(HttpMethod.POST, "/api/recipe/new").authenticated()
                    .mvcMatchers(HttpMethod.GET, "/api/recipe/**").authenticated()
                    .mvcMatchers(HttpMethod.PUT, "/api/recipe/*").authenticated()
                    .mvcMatchers(HttpMethod.DELETE, "/api/recipe/*").authenticated()
                    .and()
                .authorizeRequests()
                    .mvcMatchers(HttpMethod.POST, "/api/register", "/actuator/shutdown", "/h2").permitAll();
    }

    @Bean
    protected PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}
