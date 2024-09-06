package com.example.demo.api.layers.repository;

import com.example.demo.api.model.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestUserRepository extends JpaRepository<TestUser, Long> {
    Optional<TestUser> findById(Long ID);

    TestUser findByUsername(String username);
}
