package com.example.jeeproject.dto;

import com.example.jeeproject.models.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PostDTO {
    private String author;
    private String title;
    private String description;
    private List<CommentDTO> comments;
    private Number likesCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
