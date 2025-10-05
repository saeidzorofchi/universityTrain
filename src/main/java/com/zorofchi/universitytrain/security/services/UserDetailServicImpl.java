package com.zorofchi.universitytrain.security.services;

import com.zorofchi.universitytrain.model.auth.User;
import com.zorofchi.universitytrain.repositoy.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Data
@Service
public class UserDetailServicImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).
                orElseThrow(()->new UsernameNotFoundException(
                        "user not found whith usename " + username));
        return UserDetailsImpl.build(user) ;


    }
}
