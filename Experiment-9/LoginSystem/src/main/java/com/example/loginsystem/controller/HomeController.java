package com.example.loginsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // Looks for src/main/resources/templates/index.html
    }

    @GetMapping("/user")
    public String userPage() {
        return "user"; // You can also create user.html later
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin"; // And admin.html too
    }
}
