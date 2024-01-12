package com.example.jeeproject.service;

import com.example.jeeproject.dto.ChangePasswordDTO;
import com.example.jeeproject.models.User;

import java.util.List;

public interface IUserService {
    List<User> findAllUsers();
    User findUserById(Long userId);
    User findUserByName(String name);
    User addUser(User user);
    User updateUser(User user);
    User changePassword(ChangePasswordDTO changePasswordDTO);
    void deleteUser(Long userId);
}
