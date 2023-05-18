package ua.com.bank.bank_card.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ua.com.bank.bank_card.service.UsersManagerService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final UsersManagerService usersService;

    @Autowired
    public WebSecurityConfig(UsersManagerService usersService) {
        this.usersService = usersService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain spiFilterChain(HttpSecurity http) throws Exception {

        http.authenticationManager(
                http.getSharedObject(AuthenticationManagerBuilder.class)
                        .userDetailsService(usersService)
                        .passwordEncoder(passwordEncoder())
                        .and()
                        .build());

        http
                .csrf()
                .disable()
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/", "/info" ,"/register", "/register/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/work")
                )
                .logout((logout) -> logout
                        .permitAll()
                        .logoutSuccessUrl("/"));
        return http.build();
    }
}