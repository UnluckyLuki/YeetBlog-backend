package com.example.jeeproject.service;

import com.example.jeeproject.dto.LikeDTO;

public interface ILikeService {
    public void addLike(LikeDTO likeDTO);
    public void removeLike(long userId, long postId);
}
