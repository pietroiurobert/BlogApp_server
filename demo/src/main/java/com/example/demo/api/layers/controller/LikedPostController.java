package com.example.demo.api.layers.controller;

import com.example.demo.api.DTO.LikedPost.LikedPostDTO;
import com.example.demo.api.layers.service.LikedPostService;
import com.example.demo.api.model.Post;
import com.example.demo.api.model.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likedPosts")
public class LikedPostController {
    private final LikedPostService likedPostService;

    @Autowired
    public LikedPostController(LikedPostService likedPostService) {
        this.likedPostService = likedPostService;
    }

    @PostMapping("/likePost")
    public ResponseEntity<LikedPostDTO> likePost(@RequestParam Post post, @RequestParam TestUser testUser) {
        LikedPostDTO likedPostDTO = likedPostService.likePost(post, testUser);
        return ResponseEntity.ok(likedPostDTO);
    }
}
