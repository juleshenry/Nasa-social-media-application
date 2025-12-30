package com.derek.nasa_social_media_app.component;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.Collections;
import org.springframework.stereotype.Service;

import com.derek.nasa_social_media_app.model.UserProfile;
import com.derek.nasa_social_media_app.repository.UserProfileRepository;


@Service
public class UserProfileService implements UserDetailsService {
    
    @Autowired
    private UserProfileRepository repository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserProfile> user = repository.findByUsername(username);
        if (user.isPresent()) {
            UserProfile userObj = user.get();
            if (!userObj.isVerified()) {
                throw new UsernameNotFoundException("User not verified");
            }
            if (userObj.isBanned()) {
                throw new UsernameNotFoundException("User banned");
            }
            Collection<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + userObj.getRole().name()));
            return User.builder()
            .username(userObj.getUsername())
            .password(userObj.getUserPassword())
            .authorities(authorities)
            .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }




}
