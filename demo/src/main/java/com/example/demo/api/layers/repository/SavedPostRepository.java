package com.example.demo.api.layers.repository;

import com.example.demo.api.model.SavedPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedPostRepository extends JpaRepository<SavedPost, Long> {
}
