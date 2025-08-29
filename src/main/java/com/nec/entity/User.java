package com.nec.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String username;

    private String password;

    private String role; // ROLE_USER, ROLE_ADMIN

    // ✅ Keep this inside the class
    public UserDetails buildUserDetails() {
        return org.springframework.security.core.userdetails.User.builder()
                .username(this.email) // using email as login username
                .password(this.password)
                .roles(this.role) // ROLE_USER, ROLE_ADMIN
                .build();
    }
}
