package com.example.recipeswebsite.repository;

import com.example.recipeswebsite.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
