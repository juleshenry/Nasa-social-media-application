package com.derek.nasa_social_media_app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class UserPosts {

@Id
@GeneratedValue
private Integer id;

private String text;

private String userIdentifier;

// @ManyToOne(fetch = FetchType.LAZY)
// // @JoinColumn(name= "userProfiles_id")
// // @JsonIgnore
// @JoinTable
// private UserProfile userProfiles;

public String getUserIdentifier() {
    return userIdentifier;
}

public void setUserIdentifier(String userIdentifier) {
    this.userIdentifier = userIdentifier;
}

@ManyToOne
private UserProfile userProfiles;

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getText() {
    return text;
}

public void setText(String text) {
    this.text = text;
}

@Override
public String toString() {
    return "UserPosts [id=" + id + ", text=" + text + "]";
}

public UserProfile getUserProfiles() {
    return userProfiles;
}

public void setUserProfiles(UserProfile userProfiles) {
    this.userProfiles = userProfiles;
}

// public UserProfile getUserProfiles() {
//     return userProfiles;
// }

// public void setUserProfiles(UserProfile userProfiles) {
//     this.userProfiles = userProfiles;
// }







    
}
