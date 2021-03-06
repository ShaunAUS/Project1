package com.example.blogProject.config;


import com.example.blogProject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    private LoginService loginService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        String userId= (String)authentication.getPrincipal();
        String userPassword =(String)authentication.getPrincipal();


        //로직
        UserDetails user =loginService.loadUserByUsername(userId);

        return new UsernamePasswordAuthenticationToken(user.getUsername(), userPassword, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
