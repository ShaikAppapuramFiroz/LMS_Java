package com.nec.controller;

import com.nec.entity.User;
import com.nec.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // 🔹 Get all users
    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }

    // 🔹 Get user by ID
    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    // 🔹 Register new user (Signup)
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return service.registerUser(user);
    }

    // 🔹 Login user
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return service.loginUser(user.getEmail(), user.getPassword());
    }

    // 🔹 Update user profile
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    // 🔹 Delete user account
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
