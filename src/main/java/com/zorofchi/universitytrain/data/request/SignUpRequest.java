package com.zorofchi.universitytrain.data.request;

import com.zorofchi.universitytrain.model.auth.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpRequest {

    @NotBlank
    @Size(min = 3 , max = 20 )
    private String username;
    @NotBlank
    @Size(min = 4 , max = 40)
    private String password;
    @NotBlank
    @Email
    @Size(max = 50)
    private String email;

    private Set<String > role;


}
