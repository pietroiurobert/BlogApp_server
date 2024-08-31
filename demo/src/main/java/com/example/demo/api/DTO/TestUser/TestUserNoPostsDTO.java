package com.example.demo.api.DTO.TestUser;

import com.example.demo.api.model.TestUser;
import lombok.Data;

@Data
public class TestUserNoPostsDTO {
    private Long ID;
    private String username;
    public TestUserNoPostsDTO(TestUser testUser) {
        this.ID = testUser.getID();
        this.username = testUser.getUsername();
    }
}
