package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.security.JwtUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    private final JwtUtil jwtUtil;

    public AuthenticationController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            Authentication authentication) {

        LOGGER.info("START");

        String username = authentication.getName();

        String token =
                jwtUtil.generateToken(username);

        LOGGER.debug("JWT generated for user : {}", username);

        LOGGER.info("END");

        return Collections.singletonMap(
                "token",
                token
        );
    }
}