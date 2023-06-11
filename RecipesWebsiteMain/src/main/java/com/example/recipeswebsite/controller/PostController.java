package com.example.recipeswebsite.controller;

import com.example.recipeswebsite.model.Post;
import com.example.recipeswebsite.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Controller
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/createPost")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "post_new";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute("post") Post post) {
        Post savedPost = postService.save(post);
        return "redirect:/" ;
    }


    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model) {
        // find post by id
        Optional<Post> optionalPost = postService.getById(id);
        // if the post exists, then shove it into the model
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setCreatedAt(new Date());
            model.addAttribute("post", post);
            return "post";
        } else {
            return "404";
        }
    }

    /*
    @GetMapping("/posts/{id}/edit")
    //@PreAuthorize("isAuthenticated()")
    public String getPostForEdit(@PathVariable Long id, Model model) {

        // find post by id
        Optional<Post> optionalPost = postService.getById(id);
        // if post exist put it in model
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post_edit";
        } else {
            return "404";
        }
    }

    @GetMapping("/posts/{id}/delete")
    //@PreAuthorize("isAuthenticated()")
    public String deletePost(@PathVariable Long id) {

        // find post by id
        Optional<Post> optionalPost = postService.getById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            postService.delete(post);
            return "redirect:/";
        } else {
            return "404";
        }
    }

    @PostMapping("/posts/{id}")
    //@PreAuthorize("isAuthenticated()")
    public String updatePost(@PathVariable Long id, Post post) {

        Optional<Post> optionalPost = postService.getById(id);
        if (optionalPost.isPresent()) {
            Post existingPost = optionalPost.get();

            existingPost.setTitle(post.getTitle());
            existingPost.setPreparationTime(post.getPreparationTime());
            existingPost.setDifficultyLevel(post.getDifficultyLevel());
            existingPost.setPortionsSize(post.getPortionsSize());
            existingPost.setAverageRating(post.getAverageRating());
            existingPost.setIngredients((post.getIngredients()));
            existingPost.setSteps((post.getSteps()));

            postService.save(existingPost);
        }

        return "redirect:/posts/" + post.getId();
    }*/

}

