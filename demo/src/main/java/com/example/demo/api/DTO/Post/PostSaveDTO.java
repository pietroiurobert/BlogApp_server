package com.example.demo.api.DTO.Post;

import com.example.demo.api.model.PostCategory;
import lombok.Data;

@Data
public class PostSaveDTO {
    private String name;
    private PostCategory postCategory;
    private Long userID;
    private String content;
    private int likes;
    private int saves;

    public PostSaveDTO(String name, PostCategory postCategory, Long userID, String content, int likes, int saves) {
        this.name = name;
        this.postCategory = postCategory;
        this.userID = userID;
        this.content = content;
        this.likes = likes;
        this.saves = saves;
    }
}
