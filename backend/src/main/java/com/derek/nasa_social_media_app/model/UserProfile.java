package com.derek.nasa_social_media_app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
public class UserProfile {
    
    
    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String email;

    private String userPassword;

    private String verificationToken;

    private boolean isVerified = false;

    @Enumerated(EnumType.STRING)
    private Role role = Role.MEMBER;

    private boolean banned = false;

    private int reputation = 0;


    // @OneToMany(mappedBy = "userProfiles")
    // @JsonIgnore
	// private List<UserPosts> posts;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @JoinTable(
    //     name = "user_joined_table", // Custom join table name
    //     joinColumns = @JoinColumn(name = "user_profiles_id"), // FK to Student
    //     inverseJoinColumns = @JoinColumn(name = "posts_id") // FK to Course
    // )
	private List<UserPosts> posts;

    public UserProfile(Integer id, String username, String email, String userPassword) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.userPassword = userPassword;
    }

    public UserProfile(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }


    public List<UserPosts> getPosts() {
        return posts;
    }

    public void setPosts(List<UserPosts> posts) {
        this.posts = posts;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    @Override
    public String toString() {
        return "UserProfile [id=" + id + ", username=" + username + ", email=" + email + ", userPassword=" + userPassword + ", isVerified=" + isVerified + ", role=" + role + ", banned=" + banned + ", reputation=" + reputation + "]";
    }

  

    
}
