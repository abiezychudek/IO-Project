package com.example.recipeswebsite.services;

import com.example.recipeswebsite.model.Comment;
import com.example.recipeswebsite.model.Post;
import com.example.recipeswebsite.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post save (Post post) {
        if (post.getId() == null) {
            post.setCreatedAt(new Date());
        }
        return postRepository.save(post);
    }

    public void saveAll(List<Post> posts){

        for(Post i : posts){
            this.save(i);
        }

    }

    public void delete (Post post) {
        postRepository.delete(post);
    }

    public void addCommentToPost(Long id, Comment c){

        Optional<Post> post = postRepository.findById(id);
        Post p = post.get();
        c.setPostId(p);
        c.setCreatedAt(new Date());
        c.setAuthor("User");
        p.getComments().add(c);
        postRepository.save(p);

    }

}
