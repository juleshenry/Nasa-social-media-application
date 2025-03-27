package com.derek.nasa_social_media_app.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.derek.nasa_social_media_app.component.DataService;
import com.derek.nasa_social_media_app.component.UserService;
import com.derek.nasa_social_media_app.model.UserPosts;
import com.derek.nasa_social_media_app.model.UserProfile;
import com.derek.nasa_social_media_app.repository.UserPostsRepository;
import com.derek.nasa_social_media_app.repository.UserProfileRepository;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ProfileController {
    

@Autowired
private UserProfileRepository repository;

@Autowired
private UserPostsRepository userPostsRepository;

@Autowired
private DataService data;



    @GetMapping("/users/get")
    public List<UserProfile> getAllUsers() {
        return (List<UserProfile>) repository.findAll();
    }


    @PostMapping("/users/save")
    public UserProfile createUser(@RequestBody UserProfile userProfile) {
        return repository.save(userProfile);
    }

    @GetMapping("/home")
    public String handleUserHome() {
      return "home_users";
    }


    @GetMapping("/names")
    public List<String> findAllOnlyNames() {
    List<UserProfile> users = (List<UserProfile>) repository.findAll();
    return users.stream()
            .map(UserProfile::getUsername)
            .collect(Collectors.toList());
}
    

@PostMapping("/posts")
	public UserPosts createPostsForUser(@RequestBody UserPosts post) {
		// post.setUserIdentifier(userProfile.getUsername());
        return userPostsRepository.save(post);
}
    

@GetMapping("/users/posts")
public List<UserPosts> findAllOnlyPosts() {
// List<UserPosts> users = (List<UserPosts>) userPostsRepository.findAll();

// users.stream()
// .map(UserPosts::getText)
// .collect(Collectors.toList());

// users.stream()
// .map(UserPosts::getUserProfileName)
// .collect(Collectors.toList());

// return findAllOnlyNames();


return (List<UserPosts>) userPostsRepository.findAll();
}



// @PostMapping("/save")
// public ResponseEntity<String> saveUserContent(@RequestBody String username, @RequestBody UserPosts userSave){
//     // UserProfile user = repository.findByUsername(username);

//     UserProfile user = repository.findByUsername2(username);
  

//     if(user !=null){

//     userSave.setUserIdentifier(username);
//     userPostsRepository.save(userSave);
//     return ResponseEntity.ok("Content saved successfully!");
    
// //Must add else statement or will not work
// } else {
//     return ResponseEntity.badRequest().body("User not found!");
    

// } 

// }


// @GetMapping("/profile")
// public String getUserDetails(Authentication authentication , UserPosts posts) {
//     if (authentication.getPrincipal() instanceof UserProfile userDetails) {

//         return "Username: " + userDetails.getUsername() + ", Posts: " + posts.get();
//     }
//     return "No user details found.";
// }


@GetMapping("/profile/{name}")
public List<UserPosts> getUsersProfile(@PathVariable("name") String name) {
    return data.getUsersByName(name);
}











}
