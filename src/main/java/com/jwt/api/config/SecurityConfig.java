package com.jwt.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        request->{
                            request.requestMatchers("/auth/**").permitAll();
                            request.requestMatchers("/error").permitAll();
                            request.requestMatchers("/favicon.ico").permitAll();
                            request.anyRequest().authenticated();
                        }
                )
                .csrf(csrf->csrf.disable())
                .formLogin(withDefaults())
                .build();
    }
}
