package com.derek.nasa_social_media_app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.derek.nasa_social_media_app.component.UserService;
import com.derek.nasa_social_media_app.model.UserProfile;
import com.derek.nasa_social_media_app.repository.UserProfileRepository;


@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class UserController {
    

  // @Autowired
  // private UserProfileRepository repository;

  






    // @GetMapping("/users/get")
    // public List<UserProfile> getAllUsers() {
    //     return (List<UserProfile>) repository.findAll();
    // }


    // @PostMapping("/users/save")
    // public UserProfile createUser(@RequestBody UserProfile userProfile) {
    //     return repository.save(userProfile);
    // }

    @GetMapping("/home")
    public String handleUserHome() {
      return "home_users";
    }


    @GetMapping("/login")
    public String loginPage() {
      return "loginPage";
    }



    @GetMapping("/")
    public String redirectToUserSpecificPage() {
        String username = getLoggedInUsername();
                return "redirect:/profile/" + username;
            }
        
        private String getLoggedInUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }





}
