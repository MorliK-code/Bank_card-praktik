package ua.com.bank.bank_card.configuration;

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

    private final UsersManagerService usersManagerService;

    @Autowired
    public WebSecurityConfig(UsersManagerService usersManagerService) {
        this.usersManagerService = usersManagerService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain spiFilterChain(HttpSecurity http) throws Exception{

        http.authenticationManager(
                http.getSharedObject(AuthenticationManagerBuilder.class)
                        .userDetailsService(usersManagerService)
                        .passwordEncoder(passwordEncoder())
                        .and()
                        .build());

        http
                .csrf()
                .disable()
                .authorizeHttpRequests((authorize)->authorize
                        .requestMatchers("/","/register", "/register/**").permitAll()
                        .requestMatchers("/categorymanager","/productmanager", "/customermanager")
                        .hasRole("Admin")
                        .requestMatchers("/info")
                        .hasRole("User")
                        .requestMatchers("/manager")
                        .hasRole("Manager")
                        .anyRequest().authenticated()
                )
                .formLogin((form)-> form
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/")
                )
                .logout((logout)->logout
                        .permitAll()
                        .logoutSuccessUrl("/"));

        return http.build();
    }
}