package com.example.jeeproject.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LikeDTO {
    private Long userId;
    private Long postId;
}
