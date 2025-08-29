package com.nec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for APIs
            .authorizeHttpRequests(auth -> auth
                // Public endpoints
                .requestMatchers("/", "/login**", "/error", "/oauth2/**").permitAll()
                // Allow frontend calls
                .requestMatchers("/api/book/**").authenticated()
                .requestMatchers("/api/user/**").authenticated()
                // Admin access example (if you want roles later)
                //.requestMatchers("/api/admin/**").hasRole("ADMIN")
                // All other requests require authentication
                .anyRequest().authenticated()
            )
            // Enable OAuth2 Login (Google, GitHub, etc.)
            .oauth2Login(oauth2 -> oauth2
                .loginPage("/login")
                .defaultSuccessUrl("https://lms-java-ejbr.onrender.com", true) // Redirect to frontend after login
            )
            // Logout support
            .logout(logout -> logout
                .logoutSuccessUrl("https://lms-java-ejbr.onrender.com") // redirect to frontend after logout
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
            );

        return http.build();
    }
}
