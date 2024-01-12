package com.example.jeeproject.service;

import com.example.jeeproject.dto.CommentDTO;
import com.example.jeeproject.models.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findCommentsByPostId(Long postId);
    Comment addComment(CommentDTO commentDTO);
    Comment updateComment(Long commentId, CommentDTO commentDTO);
    void deleteComment(Long commentId);
}
