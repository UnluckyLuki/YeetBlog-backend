package com.example.jeeproject.service;

import com.example.jeeproject.dto.LikeDTO;
import com.example.jeeproject.exception.LikeNotFoundException;
import com.example.jeeproject.models.Like;
import com.example.jeeproject.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService implements ILikeService {

    private final LikeRepository likeRepository;
    private final IUserService userService;
    private final IPostService postService;

    @Override
    public void addLike(LikeDTO likeDTO) {
        Like like = new Like(userService.findUserById(likeDTO.getUserId()), postService.findPostById(likeDTO.getPostId()));
        likeRepository.save(like);
    }

    @Override
    public void removeLike(long userId, long postId) {
        Like like = likeRepository.findByUser_IdAndPost_Id(userId, postId)
                .orElseThrow(() -> new LikeNotFoundException(userId, postId));
        likeRepository.delete(like);
    }
}
