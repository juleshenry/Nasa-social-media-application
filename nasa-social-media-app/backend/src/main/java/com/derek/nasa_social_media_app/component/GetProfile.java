package com.derek.nasa_social_media_app.component;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.derek.nasa_social_media_app.model.UserProfile;

public class GetProfile implements UserDetails {

public UserProfile getAccount(){

     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return (UserProfile) authentication.getPrincipal(); // your custom fields like email, id, etc.
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
}

@Override
public String getPassword() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
}

@Override
public String getUsername() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
}
}




