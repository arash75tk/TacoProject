package org.practice.tacoproject.config;

import org.practice.tacoproject.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.practice.tacoproject.entity.User;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);
            if (user != null) return user;

            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/design", "/orders" , "/orders/current").hasRole("USER")
                        .requestMatchers("/", "/**" , "/h2-console" , "jdbc:h2:~/test" ).permitAll()
                )
                .csrf(u->u.ignoringRequestMatchers("/h2-console/**"))
                .headers(h->h.frameOptions(f->f.sameOrigin()))
                .formLogin(s-> s.loginPage("/login").defaultSuccessUrl("/design"))
                .csrf(c->c.disable())
                .build();
    }
}
