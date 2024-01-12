package com.example.jeeproject.controllers;

import com.example.jeeproject.config.JwtUtils;
import com.example.jeeproject.converters.UserConverter;
import com.example.jeeproject.dto.LoginDataDTO;
import com.example.jeeproject.dto.RegisterDataDTO;
import com.example.jeeproject.dto.TokenDTO;
import com.example.jeeproject.models.User;
import com.example.jeeproject.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final IUserService userService;
    private final JwtUtils jwtTokenUtil;

    @PostMapping("/login")
    public TokenDTO loginUser(@Valid @RequestBody LoginDataDTO loginDataDTO){
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDataDTO.getName(), loginDataDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authenticate);
        final User user = userService.findUserByName(loginDataDTO.getName());
        final String token = jwtTokenUtil.generateToken(authenticate);
        return TokenDTO.builder()
                .token(token).user(UserConverter.mapToUserDto(user))
                .build();
    }

    @PostMapping("/register")
    public TokenDTO registerUser(@Valid @RequestBody RegisterDataDTO registerDataDTO){
        User user = new User();
        user.setName(registerDataDTO.getName());
        user.setEmail(registerDataDTO.getEmail());
        user.setPassword(registerDataDTO.getPassword());
        User loggedUser = userService.addUser(user);
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(registerDataDTO.getName(), registerDataDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authenticate);

        final String token = jwtTokenUtil.generateToken(authenticate);

        return TokenDTO.builder()
                .token(token)
                .user(UserConverter.mapToUserDto(loggedUser))
                .build();
    }
}
