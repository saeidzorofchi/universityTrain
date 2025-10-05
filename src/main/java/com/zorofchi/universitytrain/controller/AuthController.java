package com.zorofchi.universitytrain.controller;


import com.zorofchi.universitytrain.data.request.LoginRequest;
import com.zorofchi.universitytrain.data.request.SignUpRequest;
import com.zorofchi.universitytrain.data.response.JwtResponse;
import com.zorofchi.universitytrain.data.response.MessageResponse;
import com.zorofchi.universitytrain.model.auth.EnumRole;
import com.zorofchi.universitytrain.model.auth.Role;
import com.zorofchi.universitytrain.model.auth.User;
import com.zorofchi.universitytrain.repositoy.RoleRepository;
import com.zorofchi.universitytrain.repositoy.UserRepository;
import com.zorofchi.universitytrain.security.jwt.JwtUtils;
import com.zorofchi.universitytrain.security.services.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("auth")
public class AuthController {


    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository repository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    RoleRepository roleRepository;

    @PostMapping("signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest ) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error : Username is already exixst !"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Email is already exixst !"));
        }
        User user = new User(
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String > strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null){
            Role userRole = roleRepository.findByName(EnumRole.ROLE_USER)
                    .orElseThrow(()-> new RuntimeException("Role is not found"));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role){
                    case "admin" :
                        Role adminRole = roleRepository.findByName(EnumRole.ROLE_ADMIN)
                    .orElseThrow(()-> new RuntimeException("Role is not found"));

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(EnumRole.ROLE_MODERATOR)
                    .orElseThrow(()-> new RuntimeException("Role is not found"));

                        break;

                    default:
                        Role userRole = roleRepository.findByName(EnumRole.ROLE_USER)
                    .orElseThrow(()-> new RuntimeException("Role is not found"));
                    roles.add(userRole);
                }


            });

        }
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("user registered successfuly"));


    }

    @PostMapping("signin")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername() , loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String > roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(
                jwt ,
                userDetails.getUsername(),
                userDetails.getId(),
                roles,
                userDetails.getEmail()
                ));

    }


}






















