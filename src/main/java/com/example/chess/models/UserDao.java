package com.example.chess.models;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDao {
    public final List<UserDetails> APPLICATION_USER = Arrays.asList(
            new User("abcd@gmai.com","pass", Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))),
            new User("pqr@gmai.com","pass", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")))
    );
    public UserDetails findUserByEmail(String email) throws UsernameNotFoundException {
        return APPLICATION_USER.stream().
                filter(u -> u.getUsername().equals(email)).
                findFirst().
                orElseThrow(() -> new UsernameNotFoundException("User not fond"));
    }
}
