package com.derek.nasa_social_media_app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derek.nasa_social_media_app.model.Message;
import com.derek.nasa_social_media_app.model.UserProfile;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message> findBySenderAndRecipient(UserProfile sender, UserProfile recipient);
    List<Message> findByRecipient(UserProfile recipient);
}