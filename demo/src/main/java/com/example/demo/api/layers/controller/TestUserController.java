package com.example.demo.api.layers.controller;

import com.example.demo.api.DTO.TestUser.TestUserDTO;
import com.example.demo.api.layers.service.TestUserService;
import com.example.demo.api.model.Post;
import com.example.demo.api.model.PostCategory;
import com.example.demo.api.model.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class TestUserController {

    private final TestUserService testUserService;

    @Autowired
    public TestUserController(TestUserService testUserService) {
        this.testUserService = testUserService;
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TestUserDTO> findUser() {
        TestUser test_user = new TestUser(1L, "pcgamerro", "1234");
        Post post = new Post(1L, "Bidirectional Relationship Using @OneToMany/@ManyToOne Annotation In Spring Boot", PostCategory.SOFTWARE_DEVELOPMENT, test_user);
        Post post2 = new Post(2L, "UI/UX Design Course", PostCategory.SOFTWARE_DEVELOPMENT, test_user);

        List<Post> posts = new ArrayList<>();
        posts.add(post);
        posts.add(post2);

        test_user.setPostList(posts);

        TestUserDTO testUserDTO = new TestUserDTO(test_user);

        return ResponseEntity.status(200).body(testUserDTO);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TestUserDTO>> findAll() {
        return ResponseEntity.ok(testUserService.findAllDTO());
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TestUserDTO> save(@RequestBody TestUser testUser) {
        return ResponseEntity.status(201).body(testUserService.save(testUser));
    }
}
