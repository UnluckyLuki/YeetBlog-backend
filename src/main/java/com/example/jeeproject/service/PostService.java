package com.example.jeeproject.service;

import com.example.jeeproject.dto.PostDTO;
import com.example.jeeproject.exception.PostByAuthorNotFoundException;
import com.example.jeeproject.exception.PostNotFoundException;
import com.example.jeeproject.models.Post;
import com.example.jeeproject.models.User;
import com.example.jeeproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService implements IPostService{

    private final PostRepository postRepository;
    private final IUserService userService;
    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post findPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));
    }

    @Override
    public List<Post> findPostsByAuthor(String userName) {
        return postRepository.findAllByUser_Name(userName)
                .orElseThrow(() -> new PostByAuthorNotFoundException(userName));
    }

    @Override
    public Post addPost(PostDTO postDTO) {
        User user = userService.findUserByName(postDTO.getAuthor());
        Post post = new Post(postDTO.getTitle(), postDTO.getDescription(), user);
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long postId, PostDTO postDTO) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));
        post.setDescription(postDTO.getDescription());
        post.setTitle(postDTO.getTitle());
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId) {
        if (postRepository.existsById(postId)){
            throw new PostNotFoundException(postId);
        }
        postRepository.deleteById(postId);
    }
}
