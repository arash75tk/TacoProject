package org.practice.tacoproject.web.controller;

import org.practice.tacoproject.entity.User;
import org.practice.tacoproject.form.LoginForm;
import org.practice.tacoproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public String login() {
        return "login";
    }
    @PostMapping
    public String login(LoginForm form) {
        try {
            User user = userRepository.findByUsername(form.getUsername());
            if (passwordEncoder.matches(form.getPassword(), user.getPassword())) {
                return "redirect:/design";
            } else
                throw new RuntimeException("Invalid username or password");
        }catch (Exception e) {
            return "login";
        }
    }
}
