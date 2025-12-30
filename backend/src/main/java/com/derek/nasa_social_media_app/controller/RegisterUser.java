package com.derek.nasa_social_media_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.derek.nasa_social_media_app.component.EmailService;
import com.derek.nasa_social_media_app.model.UserProfile;
import com.derek.nasa_social_media_app.repository.UserProfileRepository;

import java.util.UUID;

@RestController
public class RegisterUser {

    @Autowired
    private UserProfileRepository myUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;

    @PostMapping("/register/user")
    public UserProfile createUser(@RequestBody UserProfile user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        String token = UUID.randomUUID().toString();
        user.setVerificationToken(token);
        user.setVerified(false);
        UserProfile savedUser = myUserRepository.save(user);
        emailService.sendVerificationEmail(user.getEmail(), token);
        return savedUser;
    }

    @GetMapping("/verify")
    public String verifyEmail(@RequestParam String token) {
        UserProfile user = myUserRepository.findByVerificationToken(token);
        if (user != null) {
            user.setVerified(true);
            user.setVerificationToken(null);
            myUserRepository.save(user);
            return "Email verified successfully!";
        }
        return "Invalid token.";
    }

}
