package com.example.demoauthentication.controller;

import com.example.demoauthentication.service.JwtService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    public String authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        return jwtService.createToken(request.getUsername());
    }

    /* Testing purpose only */
    @GetMapping
    public String authenticateWithGet(@RequestParam String username, @RequestParam String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
        }
        return jwtService.createToken(username);
    }

    public static class AuthenticationRequest {

        private String username;

        private String password;

        public String getUsername() {
            return new String(Base64.getDecoder().decode(username));
        }

        public String getPassword() {
            return new String(Base64.getDecoder().decode(password));
        }

    }

}
