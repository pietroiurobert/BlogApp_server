package com.example.demo.api.layers.service;

import com.example.demo.api.DTO.TestUser.TestUserDTO;
import com.example.demo.api.layers.repository.PostRepository;
import com.example.demo.api.layers.repository.TestUserRepository;
import com.example.demo.api.model.Post;
import com.example.demo.api.model.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestUserService {
    private final TestUserRepository testUserRepository;
    private final PostRepository postRepository;

    @Autowired
    public TestUserService(TestUserRepository testUserRepository, PostRepository postRepository) {
        this.testUserRepository = testUserRepository;
        this.postRepository = postRepository;
    }

    public List<TestUserDTO> findAllDTO() {
        List<TestUser> testUsers = testUserRepository.findAll();
        List<TestUserDTO> testUsersDTO = new ArrayList<>();
        for(TestUser testUser : testUsers) {
            testUsersDTO.add(new TestUserDTO(testUser));
        }
        return testUsersDTO;
    }

    public TestUserDTO save(TestUser testUser) {
        // save the posts
        List<Post> posts = new ArrayList<>();

        for(Post postIn : testUser.getPostList()) {
            Post post = new Post(postIn.getID(), postIn.getName(), postIn.getPostCategory());
            post.setTestUser(testUser);
            posts.add(post);
        }
        postRepository.saveAll(posts);

        // save the user
        testUserRepository.save(testUser);
        return new TestUserDTO(testUser);
    }

    public TestUserDTO findBy(Long ID) {
        return new TestUserDTO(testUserRepository.getById(ID));
    }
}
