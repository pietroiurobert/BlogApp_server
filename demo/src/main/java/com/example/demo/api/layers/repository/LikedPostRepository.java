package com.example.demo.api.layers.repository;

import com.example.demo.api.model.LikedPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikedPostRepository extends JpaRepository<LikedPost, Long> {
}
