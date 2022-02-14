package com.kata.spring.bootstrap.spring_bootstrap.controller;


import com.kata.spring.bootstrap.spring_bootstrap.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class UserController {

    @GetMapping("/user")
    public String userPage() {
        return "user-page";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin-page";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login-page";
    }

}