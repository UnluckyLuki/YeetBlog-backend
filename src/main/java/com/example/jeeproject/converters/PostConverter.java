package com.example.jeeproject.converters;


import com.example.jeeproject.dto.PostDTO;
import com.example.jeeproject.models.Post;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostConverter {

    public static PostDTO mapToPostDto(Post post){
        return PostDTO.builder()
                .author(post.getUser().getName())
                .title(post.getTitle())
                .description(post.getDescription())
                .comments(CommentConverter.mapToCommentsDto(post.getComments()))
                .likesCount((long) post.getLikes().size())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    public static List<PostDTO> mapToPostsDto(List<Post> posts){
        return posts.stream()
                .map(PostConverter::mapToPostDto)
                .toList();
    }
}
