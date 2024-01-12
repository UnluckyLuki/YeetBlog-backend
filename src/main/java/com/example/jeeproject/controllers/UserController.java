package com.example.jeeproject.controllers;


import com.example.jeeproject.converters.UserConverter;
import com.example.jeeproject.dto.ChangePasswordDTO;
import com.example.jeeproject.dto.UserDTO;
import com.example.jeeproject.models.User;
import com.example.jeeproject.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable long userId) {
        return UserConverter.mapToUserDto(userService.findUserById(userId));
    }


    @PutMapping("/changePassword")
    public ResponseEntity<?> changeUserPassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        userService.changePassword(changePasswordDTO);
        return new ResponseEntity<>("Password was succesufly change", HttpStatus.OK);
    }

    @PutMapping("/changeName")
    public ResponseEntity<?> changeUserName(@Validated @RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>("Name of user was changed to: " + user.getName(), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
    }
}
