package com.example.jeeproject.dto;

import com.example.jeeproject.models.constraints.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDataDTO {
    @NotEmpty
    private String name;
    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    @ValidPassword
    private String password;
}
