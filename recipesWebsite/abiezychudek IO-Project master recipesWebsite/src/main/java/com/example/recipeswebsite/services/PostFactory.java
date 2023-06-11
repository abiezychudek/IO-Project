package com.example.recipeswebsite.services;

import com.example.recipeswebsite.Factory.PostData;
import com.example.recipeswebsite.model.*;
import com.example.recipeswebsite.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostFactory {
    private final PostRepository postRepository;

    @Autowired
    public PostFactory(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(PostData postData) {
        String category = postData.getCategory();
        if (category == null) {
            return null;
        }

        Post post;

        if (category.equalsIgnoreCase("DESSERT")) {
            DessertPost dessertPost = new DessertPost(postData);
            dessertPost.setSweetnessLevel(postData.getSweetnessLevel());
            post = dessertPost;
        } else if (category.equalsIgnoreCase("BREAKFAST")) {
            BreakfastPost breakfastPost = new BreakfastPost(postData);
            breakfastPost.setVegetarian(postData.isVegetarian());
            post = breakfastPost;
        } else if (category.equalsIgnoreCase("LUNCH")) {
            LunchPost lunchPost = new LunchPost(postData);
            lunchPost.setFastMaking(postData.isFastMaking());
            post = lunchPost;
        } else if (category.equalsIgnoreCase("DINNER")) {
            DinnerPost dinnerPost = new DinnerPost(postData);
            dinnerPost.setLightweight(postData.isLightweight());
            post = dinnerPost;
        } else {
            return null;
        }

        return save(post);
    }

    public Post save(Post post) {
        if (post.getId() == null) {
            post.setCreatedAt(new Date());
        }
        return (Post) postRepository.save(post);
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    public void saveAll(List<Post> post1) {
        postRepository.saveAll(post1);
    }
}
