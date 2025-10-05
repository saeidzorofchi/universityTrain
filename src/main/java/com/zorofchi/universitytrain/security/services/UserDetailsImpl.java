package com.zorofchi.universitytrain.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zorofchi.universitytrain.model.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Data
public class UserDetailsImpl implements UserDetails {


    private int id;
    private String username ;
    private String email;
    @JsonIgnore
    private String password;
    public static Collection<? extends GrantedAuthority> authorities;



    public UserDetailsImpl(int id, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }



     public static UserDetailsImpl build(User user){
         List<GrantedAuthority> authorities = user.getRoles().stream()
                 .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                 .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities);




     }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

}
