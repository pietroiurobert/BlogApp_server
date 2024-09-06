package com.example.demo.api.layers.service;

import com.example.demo.api.DTO.Post.PostDTO;
import com.example.demo.api.DTO.Post.PostSaveDTO;
import com.example.demo.api.layers.repository.PostRepository;
import com.example.demo.api.layers.repository.TestUserRepository;
import com.example.demo.api.model.Post;
import com.example.demo.api.model.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final TestUserRepository testUserRepository;

    @Autowired
    public PostService(PostRepository postRepository, TestUserRepository testUserRepository) {
        this.postRepository = postRepository;
        this.testUserRepository = testUserRepository;
    }

    public List<PostDTO> findAllDTO() {
        List<PostDTO> postDTOList = new ArrayList<>();
        List<Post> postList = postRepository.findAll();
        for(Post post : postList) {
            postDTOList.add(new PostDTO(post));
        }
        return postDTOList;
    }

    public PostDTO save(PostSaveDTO postSaveDTO) {
        TestUser testUser = testUserRepository.getById(postSaveDTO.getUserID());
        Post post = Post.builder()
                .name(postSaveDTO.getName())
                .postCategory(postSaveDTO.getPostCategory())
                .content(postSaveDTO.getContent())
                .testUser(testUser)
                .build();

        postRepository.save(post);

        return new PostDTO(post);
    }

    public PostDTO save(Post post) {
        postRepository.save(post);
        return new PostDTO(post);
    }
}
