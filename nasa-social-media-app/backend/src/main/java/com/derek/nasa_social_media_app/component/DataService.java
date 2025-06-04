package com.derek.nasa_social_media_app.component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.derek.nasa_social_media_app.model.UserPosts;
import com.derek.nasa_social_media_app.model.UserProfile;
import com.derek.nasa_social_media_app.repository.UserPostsRepository;
import com.derek.nasa_social_media_app.repository.UserProfileRepository;

@Service
public class DataService {

    @Autowired
    private UserProfileRepository repo;

    @Autowired
    private UserPostsRepository postRepo;



    public List<UserPosts> getUsersByName(String details) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            details = userDetails.getUsername();

            return postRepo.findByUserIdentifier(details);
        
        } else {
            return null;
        }
               
              
        
        
    }




    public List<UserPosts> getAllPosts() {
        return (List<UserPosts>) postRepo.findAll();
    }






    public Optional<UserProfile> getUsersByProfile(String name) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            name = userDetails.getUsername();

            return repo.findByUsername(name);
        
        } else {
            return null;
        }
               
              
        
        
    }


    public String getUserNames(String name){

     String names = ((UserProfile) repo.findAll()).getUsername();
     return names;
    }

    // public String getLoggedInUsername() {
    //     Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    //     if (principal instanceof UserDetails) {
    //         return ((UserDetails) principal).getUsername();
    //     } else {
    //         return principal.toString();
    //     }
    // }


    
}
