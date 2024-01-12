package com.example.jeeproject.service;

import com.example.jeeproject.dto.CommentDTO;
import com.example.jeeproject.exception.CommentNotFoundException;
import com.example.jeeproject.exception.PostNotFoundException;
import com.example.jeeproject.models.Comment;
import com.example.jeeproject.models.Post;
import com.example.jeeproject.models.User;
import com.example.jeeproject.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService {

    private final CommentRepository commentRepository;
    private final IUserService userService;
    private final IPostService postService;

    @Override
    public List<Comment> findCommentsByPostId(Long postId) {
        return commentRepository.findAllByPost_Id(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));
    }

    @Override
    public Comment addComment(CommentDTO commentDTO) {
        User user = userService.findUserByName(commentDTO.getAuthor());
        Post post = postService.findPostById(commentDTO.getPostId());
        Comment comment = new Comment(commentDTO.getMessage(), user, post);
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Long commentId, CommentDTO commentDTO) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException(commentId));
        comment.setMessage(commentDTO.getMessage());
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        if (commentRepository.existsById(commentId)) {
            throw new CommentNotFoundException(commentId);
        }
        commentRepository.deleteById(commentId);
    }
}
