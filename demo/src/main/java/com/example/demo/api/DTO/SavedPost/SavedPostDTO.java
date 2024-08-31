package com.example.demo.api.DTO.SavedPost;

import com.example.demo.api.DTO.Post.PostDTO;
import com.example.demo.api.DTO.TestUser.TestUserNoPostsDTO;
import com.example.demo.api.model.LikedPost;
import lombok.Data;

@Data
public class SavedPostDTO {
    private PostDTO postDTO;
    private TestUserNoPostsDTO testUserNoPostsDTO;
    public SavedPostDTO(LikedPost likedPost) {
        this.postDTO = new PostDTO(likedPost.getPost());
        this.testUserNoPostsDTO = new TestUserNoPostsDTO(likedPost.getTestUser());
    }
}
