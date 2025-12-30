package com.derek.nasa_social_media_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private Integer id;

    private String content;

    @ManyToOne
    private UserProfile sender;

    @ManyToOne
    private UserProfile recipient;

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserProfile getSender() {
        return sender;
    }

    public void setSender(UserProfile sender) {
        this.sender = sender;
    }

    public UserProfile getRecipient() {
        return recipient;
    }

    public void setRecipient(UserProfile recipient) {
        this.recipient = recipient;
    }
}