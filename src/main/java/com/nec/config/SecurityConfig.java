package com.nec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/signup", "/css/**", "/js/**", "/images/**").permitAll() // allow public
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")      // custom login page
                .defaultSuccessUrl("/", true) // redirect after successful login
                .permitAll()
            )
            .oauth2Login(oauth -> oauth
                .loginPage("/login")      // same login page for Google/GitHub
                .defaultSuccessUrl("/", true)
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }
}
