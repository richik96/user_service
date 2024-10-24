package com.scaler.user_service_oct24.configs;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->
                    {
                        try {
                            authorizeRequests
                                .anyRequest().permitAll()
                                    .and().cors().disable()
                                    .csrf().disable();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        return http.build();
    }
}
