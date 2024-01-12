package com.example.jeeproject.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserWithPostsDTO {
    private String name;
    private List<PostDTO> posts;
}
