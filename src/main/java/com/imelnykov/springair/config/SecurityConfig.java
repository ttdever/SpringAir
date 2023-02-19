package com.imelnykov.springair.config;

import com.imelnykov.springair.authentication.CustomAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/login*", "/oauth2*").permitAll()
                .anyRequest().authenticated()
                .and().authenticationProvider(authenticationProvider())
                .formLogin()
                .and().oauth2Login();
        return http.build();
    }

    @Bean
    public CustomAuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }
}