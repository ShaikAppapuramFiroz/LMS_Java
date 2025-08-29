package com.nec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // maps to login.html in templates
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup"; // maps to signup.html in templates
    }
}
