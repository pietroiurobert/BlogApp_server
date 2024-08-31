package com.example.demo.api.DTO.Post;

import com.example.demo.api.DTO.TestUser.TestUserNoPostsDTO;
import com.example.demo.api.model.Post;
import com.example.demo.api.model.PostCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostDTO {
    private String name;
    private PostCategory postCategory;
    @JsonProperty("testUser")
    private TestUserNoPostsDTO testUserNoPostsDTO;

    public PostDTO(Post post) {
        this.name = post.getName();
        this.postCategory = post.getPostCategory();
        this.testUserNoPostsDTO = new TestUserNoPostsDTO(post.getTestUser());
    }
}
