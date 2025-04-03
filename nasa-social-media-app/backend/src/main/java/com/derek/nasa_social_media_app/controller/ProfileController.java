package com.derek.nasa_social_media_app.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
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


@CrossOrigin(origins = "http://localhost:3000")
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
    
@CrossOrigin(origins = "http://localhost:3000")
@GetMapping("/users/posts")
public List<UserPosts> findAllPosts() {
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

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody UserProfile user) {
  // Your login logic here
  return ResponseEntity.ok("Login successful");
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


// @GetMapping("/profile/{name}")
// public List<UserPosts> getUsersProfile(@PathVariable("name") String name) {
//     return data.getUsersByName(name);
// }

@GetMapping("/profile/{username}")
    public Optional<UserProfile> getUserInfo(@PathVariable("username") String username,
                              @AuthenticationPrincipal UserProfile loggedInUser) {
        // Check if the logged-in user is the same as the path variable
        if (loggedInUser != null && loggedInUser.getUsername().equals(username)) {
            return data.getUsersByProfile(username);
        } else {
            return null ;
        }
    }




// @GetMapping("/")
// public Map<String, String> getUserData() {
//     String username = getLoggedInUsername(null);
//     String text = getCustomMessagee(); // Get dynamic text
    
//     return Map.of(
//         "name", username,
//         "text", text
//     );
// }


 
// public String getLoggedInUsername(@AuthenticationPrincipal UserDetails userDetails) {
//     return userDetails.getUsername();
// }  


// private String getCustomMessage() {
//     // Example logic: customize message based on username
//     return username;
// }


// @GetMapping("/{username}")
// public ResponseEntity<?> getUserProfile(@PathVariable String userIdentifier) {
//     Optional<UserPosts> userOptional = userOptional.stream()
//         .filter(u -> u.getUserIdentifier() == userIdentifier)
//         .findFirst();

//     if (userOptional.isEmpty()) {
//         return ResponseEntity.status(HttpStatus.NOT_FOUND)
//             .body(Map.of("error", "User not found"));
//     }

//     UserPosts user = userOptional.get();
    
//     // Create response with only selected fields
//     Map<String, Object> response = new HashMap<>();
//     response.put("username", user.getUserIdentifier());
//     response.put("posts", user.getText());

//     return ResponseEntity.ok(response);
// }

// @GetMapping("/{username}")
// public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
//     return users.stream()
//             .filter(user -> user.getUsername().equals(username))
//             .findFirst()
//             .map(ResponseEntity::ok)
//             .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
//                     .body("User with username '" + username + "' not found"));
// }




    

    // Constructor injection
  
   


        
     @GetMapping("/user-posts")
     public Map<String, String> getUserPosts() {
        return data.getAllPosts().stream()
        .collect(Collectors.toMap(UserPosts::getUserIdentifier, UserPosts::getText));
        }



    // Filter Users by Username using Streams
    // @GetMapping("/user")
    // public User getUserByUsername(@RequestParam String username) {
    //     return userService.getAllUsers().stream()
    //             .filter(user -> user.getUsername().equalsIgnoreCase(username))
    //             .findFirst()
    //             .orElse(null);
    // }




//     @GetMapping("/names")
//     public List<String> findAllOnlyNames() {
//     List<UserProfile> users = (List<UserProfile>) repository.findAll();
//     return users.stream()
//             .map(UserProfile::getUsername)
//             .collect(Collectors.toList());
// }





}
