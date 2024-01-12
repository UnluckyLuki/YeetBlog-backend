package com.example.jeeproject.repository;

import com.example.jeeproject.models.Comment;
import com.example.jeeproject.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<List<Comment>> findAllByPost_Id(Long post_id);
}
