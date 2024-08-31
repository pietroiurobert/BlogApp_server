package com.example.demo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "test_user")

@AllArgsConstructor
@NoArgsConstructor
public class TestUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnore
    private Long ID;
    private String username;
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "testUser", cascade = CascadeType.ALL)
    private List<Post> postList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "testUser", cascade = CascadeType.ALL)
    private List<SavedPost> savedPostList= new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "testUser", cascade = CascadeType.ALL)
    private List<LikedPost> likedPossList = new ArrayList<>();

    public TestUser(Long ID, String username, String password) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.postList = new ArrayList<>();
        this.savedPostList = new ArrayList<>();
        this.likedPossList = new ArrayList<>();
    }
}
