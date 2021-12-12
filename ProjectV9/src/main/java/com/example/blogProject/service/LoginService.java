package com.example.blogProject.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {


        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();




        if ("user".equals(userId)) {
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if ("admin".equals(userId)) {
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            return null;
        }
        return new User(userId, userId, roles);
    }
}
