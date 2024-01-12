package com.example.jeeproject.repository;

import com.example.jeeproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUsersByName(String name);
    Optional<User> findUsersByEmail(String email);
    Boolean existsByName(String name);

}
