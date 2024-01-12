package com.example.jeeproject.service;

import com.example.jeeproject.dto.PostDTO;
import com.example.jeeproject.models.Post;
import com.example.jeeproject.models.User;

import java.util.List;

public interface IPostService {
    List<Post> findAllPosts();
    Post findPostById(Long postId);
    List<Post> findPostsByAuthor(String userName);
    Post addPost(PostDTO postDTO);
    Post updatePost(Long postId, PostDTO postDTO);
    void deletePost(Long postId);

}
