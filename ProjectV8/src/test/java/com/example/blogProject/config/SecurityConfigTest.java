package com.example.blogProject.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SecurityConfigTest {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testEncode(){

        String pass = "111";

        String encode = passwordEncoder.encode(pass);

        System.out.println("encode = " + encode);

        boolean matches = passwordEncoder.matches(pass, encode);

        System.out.println("matches = " + matches);


    }
}