package com.example.jeeproject.service;

import com.example.jeeproject.dto.ChangePasswordDTO;
import com.example.jeeproject.exception.OldPasswordInvalidException;
import com.example.jeeproject.exception.UserAlreadyExistsException;
import com.example.jeeproject.exception.UserNotFoundException;
import com.example.jeeproject.models.User;
import com.example.jeeproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        User user = userRepository.findUsersByName(username)
                .orElseThrow(() -> new UserNotFoundException(username));
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                new ArrayList<>()
        );
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findUsersByName(name)
                .orElseThrow(() -> new UserNotFoundException(name));
    }

    @Override
    public User addUser(User user){
        if (userRepository.existsByName(user.getName())){
            throw new UserAlreadyExistsException(user.getName());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (userRepository.existsByName(user.getName())){
            throw new UserAlreadyExistsException(user.getName());
        }
        return userRepository.save(user);
    }

    @Override
    public User changePassword(ChangePasswordDTO changePasswordDTO) {
        User user = userRepository.findById(changePasswordDTO.getId())
                .orElseThrow(() -> new UserNotFoundException(changePasswordDTO.getId()));
        if(!user.getPassword().equals(passwordEncoder.encode(changePasswordDTO.getOldPassword()))){
            throw new OldPasswordInvalidException();
        }
        user.setPassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        if(!userRepository.existsById(userId)){
            throw new UserNotFoundException(userId);
        }
        userRepository.deleteById(userId);
    }

}
