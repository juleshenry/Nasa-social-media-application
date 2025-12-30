package com.derek.nasa_social_media_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Vote {

    @Id
    @GeneratedValue
    private Integer id;

    private boolean isUpvote; // true for up, false for down

    @ManyToOne
    private UserProfile voter;

    @ManyToOne
    private Thread thread;

    @ManyToOne
    private Reply reply;

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isUpvote() {
        return isUpvote;
    }

    public void setUpvote(boolean upvote) {
        isUpvote = upvote;
    }

    public UserProfile getVoter() {
        return voter;
    }

    public void setVoter(UserProfile voter) {
        this.voter = voter;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }
}