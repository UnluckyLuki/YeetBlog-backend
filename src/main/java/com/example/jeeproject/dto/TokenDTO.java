package com.example.jeeproject.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenDTO {
    private String token;
    private UserDTO user;
}
