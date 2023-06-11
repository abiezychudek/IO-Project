package com.example.recipeswebsite.controller;

import com.example.recipeswebsite.Factory.PostData;
import com.example.recipeswebsite.model.Comment;
import com.example.recipeswebsite.model.Post;
import com.example.recipeswebsite.services.PostFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class PostController {

    private final PostFactory postFactory;

    @Autowired
    public PostController(PostFactory postFactory) {
        this.postFactory = postFactory;
    }

    @GetMapping("/createPost")
    public String showCreateForm(Model model) {
        model.addAttribute("postData", new PostData());
        return "post_new";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute("postData") PostData postData, Authentication authentication) {

        String author = authentication.getName() ;
        postData.setAuthor(author);
        Post post = postFactory.createPost(postData);
        postFactory.save(post);
        if (post.getId() != null) {
            return "redirect:/posts/" + post.getId();
        } else {
            return "post_new";
        }

    }


    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model) {
        // find post by id
        Optional<Post> optionalPost = postFactory.getById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            model.addAttribute("comment", new Comment());
            return "post";
        } else {
            return "home";
        }
    }

    //to change
    @PostMapping("/posts/{id}")
    public String addComment(@PathVariable Long id, @ModelAttribute("comment") Comment comment, Model model) {

        postFactory.addCommentToPost(id, comment);

        return "redirect:/posts/" + id;

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

