package com.example.demo.api.layers.service;

import com.example.demo.api.DTO.LikedPost.LikedPostDTO;
import com.example.demo.api.layers.repository.LikedPostRepository;
import com.example.demo.api.model.LikedPost;
import com.example.demo.api.model.Post;
import com.example.demo.api.model.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikedPostService {
    private final LikedPostRepository likedPostRepository;

    @Autowired
    public LikedPostService(LikedPostRepository likedPostRepository) {
        this.likedPostRepository = likedPostRepository;
    }

    public LikedPostDTO likePost(Post post, TestUser testUser) {
        LikedPost likedPost = new LikedPost(post, testUser);
        likedPostRepository.save(likedPost);
        return new LikedPostDTO(likedPost);
    }

    public String unlikePost(LikedPost likedPost) {
        likedPostRepository.delete(likedPost);
        return "post unliked successfully";
    }
}
