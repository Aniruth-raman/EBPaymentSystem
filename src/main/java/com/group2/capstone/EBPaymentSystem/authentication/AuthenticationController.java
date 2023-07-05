package com.group2.capstone.EBPaymentSystem.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtRequest jwtRequest) {
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
            final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (AuthenticationException e) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
