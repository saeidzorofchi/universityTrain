package com.zorofchi.universitytrain.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JwtResponse {

    private String token;
    private String type = "Bearare";

    private long id;
    private String username;
    private String email;
    private List<String> roles;


    public JwtResponse(String jwt, String username, int id, List<String> roles, String email) {
    }
}
