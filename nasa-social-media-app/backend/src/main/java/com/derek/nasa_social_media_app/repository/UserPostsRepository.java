package com.derek.nasa_social_media_app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.derek.nasa_social_media_app.model.UserPosts;

public interface UserPostsRepository extends CrudRepository<UserPosts, Integer>  {
    
    List<UserPosts> findByUserIdentifier(String userIdentifier);



}
