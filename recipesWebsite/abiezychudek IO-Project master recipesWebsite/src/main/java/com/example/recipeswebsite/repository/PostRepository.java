package com.example.recipeswebsite.repository;

import com.example.recipeswebsite.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository<T extends Post> extends JpaRepository<T, Long> {
}
