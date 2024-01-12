package com.example.jeeproject.repository;

import com.example.jeeproject.models.Post;
import com.example.jeeproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<List<Post>> findAllByUser_Name(String userName);
}
