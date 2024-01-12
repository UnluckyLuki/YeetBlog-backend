package com.example.jeeproject.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDataDTO {
    @NotEmpty
    String name;
    @NotEmpty
    String password;
}
