package com.derek.nasa_social_media_app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derek.nasa_social_media_app.model.UserProfile;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, Integer>  {
    
    Optional<UserProfile> findByUsername(String username);
    // UserProfile findByUsername(String username);

    
}
