package com.example.jeeproject.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommentDTO {
    private String author;
    private String message;
    private Long postId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
