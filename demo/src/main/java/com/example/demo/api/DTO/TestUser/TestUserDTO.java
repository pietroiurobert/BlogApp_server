package com.example.demo.api.DTO.TestUser;

import com.example.demo.api.DTO.LikedPost.LikedPostDTO;
import com.example.demo.api.DTO.Post.PostDTO;
import com.example.demo.api.model.Post;
import com.example.demo.api.model.TestUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TestUserDTO {
    private String username;

    @JsonProperty("posts")
    private List<PostDTO> postDTOList;

    @JsonProperty("likedPosts")
    private List<LikedPostDTO> likedPostDTOList;

    public TestUserDTO(TestUser test_user) {
        this.username = test_user.getUsername();
        this.postDTOList = new ArrayList<>();
        for(Post post : test_user.getPostList()) {
            postDTOList.add(new PostDTO(post));
        }
    }
}

