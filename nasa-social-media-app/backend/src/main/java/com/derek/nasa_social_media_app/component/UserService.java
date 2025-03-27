package com.derek.nasa_social_media_app.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.derek.nasa_social_media_app.model.UserProfile;

@Component
public class UserService {
    
    private static List<UserProfile> users = new ArrayList<>();
    
    
    
    
    private int usersCount = 0;
    
    public UserProfile saveUserProfile(UserProfile userProfile) {
		userProfile.setId(++usersCount);
		users.add(userProfile);
		return userProfile;
	}


// 	static {

// 		users.add(new UserProfile(1,"derek","red"));

// }






}
