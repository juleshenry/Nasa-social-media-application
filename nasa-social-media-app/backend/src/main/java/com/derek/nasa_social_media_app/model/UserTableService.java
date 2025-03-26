package com.derek.nasa_social_media_app.model;
import com.derek.nasa_social_media_app.repository.UserProfileRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derek.nasa_social_media_app.repository.UserPostsRepository;

@Service
public class UserTableService {


    

    @Autowired
    private UserPostsRepository postsRepository;
    
    @Autowired
    private UserProfileRepository userProfileRepository;


    @Transactional
    public void enrollStudentInCourses() {
        // Create and save courses
        UserPosts post1 = new UserPosts();
        post1.setText("hello");
        postsRepository.save(post1);

        // Course course2 = new Course();
        // course2.setTitle("Science");
        // courseRepository.save(course2);

        // Create student and associate with courses
        UserProfile user1 = new UserProfile();
        user1.setUsername("Dan");
        user1.setUserPassword("blue");

        user1.getPosts().add(post1);

        // Saving student also saves the relationships in the join table
        userProfileRepository.save(user1);
    }
}


