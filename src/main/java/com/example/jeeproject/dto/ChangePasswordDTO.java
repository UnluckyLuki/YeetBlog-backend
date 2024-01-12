package com.example.jeeproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordDTO {
    private Long id;
    private String OldPassword;
    private String NewPassword;
}
