package com.derek.nasa_social_media_app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.derek.nasa_social_media_app.model.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile, Integer>  {
    
    Optional<UserProfile> findByUsername(String username);

    UserProfile findByUsername2(String username);
}
