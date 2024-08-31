package com.example.demo.api.DTO.LikedPost;

import com.example.demo.api.DTO.Post.PostDTO;
import com.example.demo.api.DTO.TestUser.TestUserNoPostsDTO;
import com.example.demo.api.model.LikedPost;
import lombok.Data;

@Data
public class LikedPostDTO {
    private PostDTO postDTO;
    private TestUserNoPostsDTO testUserNoPostsDTO;

    public LikedPostDTO(LikedPost likedPost) {
        this.postDTO = new PostDTO(likedPost.getPost());
        this.testUserNoPostsDTO = new TestUserNoPostsDTO(likedPost.getTestUser());
    }
}
