package com.example.chess.controller;

import com.example.chess.configs.JwtUtil;
import com.example.chess.models.UserDao;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationContoller {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtil jwtUtil;

    public AuthenticationContoller(AuthenticationManager authenticationManager, UserDao userDao, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDao = userDao;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")

    public ResponseEntity<String> authenticatie(@RequestParam String email, @RequestParam String password){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        final UserDetails user = userDao.findUserByEmail(email);
        if(user != null){
            return ResponseEntity.ok(jwtUtil.generateToken(user));
        }
        return ResponseEntity.status(404).body("Error");
    }
}
