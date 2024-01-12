package com.example.jeeproject.controllers;

import com.example.jeeproject.converters.CommentConverter;
import com.example.jeeproject.converters.PostConverter;
import com.example.jeeproject.dto.CommentDTO;
import com.example.jeeproject.dto.PostDTO;
import com.example.jeeproject.dto.UserWithPostsDTO;
import com.example.jeeproject.models.Post;
import com.example.jeeproject.models.User;
import com.example.jeeproject.service.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/comment")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class CommentController {

    private final ICommentService commentService;

    @PostMapping("")
    public CommentDTO addComment(@RequestBody CommentDTO commentDTO) {
        return CommentConverter.mapToCommentDto(commentService.addComment(commentDTO));
    }

    @GetMapping("/{postId}")
    public List<CommentDTO>  getCommentsByPostId(@PathVariable long postId) {
        return CommentConverter.mapToCommentsDto(commentService.findCommentsByPostId(postId));
    }

    @PutMapping("/{commentId}")
    public CommentDTO updatePost(@PathVariable long commentId, @RequestBody CommentDTO commentDTO) {
        return CommentConverter.mapToCommentDto(commentService.updateComment(commentId, commentDTO));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> deletePost(@PathVariable long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>("Comment was successfully deleted.", HttpStatus.OK);
    }

}
