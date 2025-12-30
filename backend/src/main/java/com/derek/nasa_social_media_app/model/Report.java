package com.derek.nasa_social_media_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Report {

    @Id
    @GeneratedValue
    private Integer id;

    private String reason;

    @ManyToOne
    private UserProfile reporter;

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public UserProfile getReporter() {
        return reporter;
    }

    public void setReporter(UserProfile reporter) {
        this.reporter = reporter;
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