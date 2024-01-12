package com.example.jeeproject.controllers;

import com.example.jeeproject.converters.PostConverter;
import com.example.jeeproject.dto.PostDTO;
import com.example.jeeproject.dto.UserWithPostsDTO;
import com.example.jeeproject.models.Post;
import com.example.jeeproject.models.User;
import com.example.jeeproject.service.IPostService;
import com.example.jeeproject.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/post")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class PostController {
    private final IPostService postService;

    @PostMapping("")
    public PostDTO addPost(@RequestBody PostDTO postDTO){
        return PostConverter.mapToPostDto(postService.addPost(postDTO));
    }

    @GetMapping("/{postId}")
    public PostDTO getPost(@PathVariable long postId){
        return PostConverter.mapToPostDto(postService.findPostById(postId));
    }

    @PutMapping("/{postId}")
    public PostDTO updatePost(@PathVariable long postId, @RequestBody PostDTO postDTO){
        return PostConverter.mapToPostDto(postService.updatePost(postId, postDTO));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable long postId){
        postService.deletePost(postId);
        return new ResponseEntity<>("Post was succufuly deleted.", HttpStatus.OK);
    }

    @GetMapping("/byUser/{userName}")
    public UserWithPostsDTO getUserWithPosts(@PathVariable String userName){
        return UserWithPostsDTO.builder()
                .name(userName)
                .posts(PostConverter.mapToPostsDto(postService.findPostsByAuthor(userName)))
                .build();
    }


}
