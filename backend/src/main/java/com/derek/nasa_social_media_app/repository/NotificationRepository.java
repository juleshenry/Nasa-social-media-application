package com.derek.nasa_social_media_app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derek.nasa_social_media_app.model.Notification;
import com.derek.nasa_social_media_app.model.UserProfile;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Integer> {
    List<Notification> findByRecipientAndIsRead(UserProfile recipient, boolean isRead);
}