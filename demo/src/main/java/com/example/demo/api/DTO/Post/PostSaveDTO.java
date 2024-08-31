package com.example.demo.api.DTO.Post;

import com.example.demo.api.model.PostCategory;
import lombok.Data;

@Data
public class PostSaveDTO {
    private String name;
    private PostCategory postCategory;
    private Long userID;

    public PostSaveDTO(String name, PostCategory postCategory, Long userID) {
        this.name = name;
        this.postCategory = postCategory;
        this.userID = userID;
    }
}
