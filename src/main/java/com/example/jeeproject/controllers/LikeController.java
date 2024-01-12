package com.example.jeeproject.controllers;

import com.example.jeeproject.dto.LikeDTO;
import com.example.jeeproject.service.ILikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/like")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class LikeController {

    private final ILikeService likeService;
    @PostMapping("")
    public ResponseEntity<?> addLike(@RequestBody LikeDTO likeDTO){
        likeService.addLike(likeDTO);
        return new ResponseEntity<>("Like successfully added.", HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/{postId}")
    public ResponseEntity<?> removeLike(@PathVariable long userId, @PathVariable long postId){
        likeService.removeLike(userId, postId);
        return new ResponseEntity<>("Like successfully deleted", HttpStatus.OK);
    }
}
