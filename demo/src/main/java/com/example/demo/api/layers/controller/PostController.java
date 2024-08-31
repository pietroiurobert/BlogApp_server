package com.example.demo.api.layers.controller;

import com.example.demo.api.DTO.Post.PostDTO;
import com.example.demo.api.DTO.Post.PostSaveDTO;
import com.example.demo.api.layers.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<PostDTO>> findAllDTO() {
        return ResponseEntity.ok(postService.findAllDTO());
    }

    @PostMapping("/save")
    public ResponseEntity<PostDTO> save(@RequestBody PostSaveDTO postSaveDTO) {
        return ResponseEntity.status(201).body(postService.save(postSaveDTO));
    }
}
