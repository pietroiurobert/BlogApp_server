package com.example.demo.api.layers.service;

import com.example.demo.api.DTO.TestUser.TestUserDTO;
import com.example.demo.api.layers.repository.PostRepository;
import com.example.demo.api.layers.repository.TestUserRepository;
import com.example.demo.api.model.Post;
import com.example.demo.api.model.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestUserService {
    private final TestUserRepository testUserRepository;
    private final PostRepository postRepository;
    private final AuthenticationManager authManager;
    private final JWTService jwtService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    public TestUserService(TestUserRepository testUserRepository, PostRepository postRepository, AuthenticationManager authManager, JWTService jwtService) {
        this.testUserRepository = testUserRepository;
        this.postRepository = postRepository;
        this.authManager = authManager;
        this.jwtService = jwtService;
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
        testUser.setPassword(encoder.encode(testUser.getPassword()));
        testUserRepository.save(testUser);
        return new TestUserDTO(testUser);
    }

    public TestUserDTO findBy(Long ID) {
        return new TestUserDTO(testUserRepository.getById(ID)); // getById is deprecated. needs to be replaced
    }

    public TestUserDTO findByToken(String token) {
        String username = jwtService.extractUserName(token);
        TestUser testUser = testUserRepository.findByUsername(username);
        return new TestUserDTO(testUser);
    }

    public String verify(TestUser testUser) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(testUser.getUsername(), testUser.getPassword());
        Authentication authentication = authManager.authenticate(authenticationToken);
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(testUser.getUsername()); // replace with token
        } else {
            return "Not Authenticated";
        }
    }
}
