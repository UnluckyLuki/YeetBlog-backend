package com.example.jeeproject.converters;

import com.example.jeeproject.models.User;
import com.example.jeeproject.dto.UserDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConverter {
    public static UserDTO mapToUserDto(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
    public static List<UserDTO> mapToUsersDto(List<User> users) {
        return users.stream()
                .map(UserConverter::mapToUserDto)
                .toList();
    }
}
