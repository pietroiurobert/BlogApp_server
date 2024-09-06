package com.example.demo.api.layers.controller;

import com.example.demo.api.DTO.TestUser.TestUserDTO;
import com.example.demo.api.layers.service.TestUserService;
import com.example.demo.api.model.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class TestUserController {

    private final TestUserService testUserService;

    @Autowired
    public TestUserController(TestUserService testUserService) {
        this.testUserService = testUserService;
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TestUserDTO>> findAll() {
        return ResponseEntity.ok(testUserService.findAllDTO());
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TestUserDTO> save(@RequestBody TestUser testUser) {
        return ResponseEntity.status(201).body(testUserService.save(testUser));
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody TestUser testUser) {
        String verify = testUserService.verify(testUser);
        return ResponseEntity.status(200).body(verify);
    }
}
