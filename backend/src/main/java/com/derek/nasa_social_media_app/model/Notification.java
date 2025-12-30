package com.derek.nasa_social_media_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Notification {

    @Id
    @GeneratedValue
    private Integer id;

    private String message;

    private boolean isRead = false;

    @ManyToOne
    private UserProfile recipient;

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public UserProfile getRecipient() {
        return recipient;
    }

    public void setRecipient(UserProfile recipient) {
        this.recipient = recipient;
    }
}