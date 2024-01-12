package com.example.jeeproject.converters;

import com.example.jeeproject.dto.CommentDTO;
import com.example.jeeproject.models.Comment;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentConverter {
    public static CommentDTO mapToCommentDto(Comment comment){
        return CommentDTO.builder()
                .author(comment.getUser().getName())
                .message(comment.getMessage())
                .postId(comment.getPost().getId())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }

    public static List<CommentDTO> mapToCommentsDto(List<Comment> comments){
        return comments.stream()
                .map(CommentConverter::mapToCommentDto)
                .toList();
    }
}
