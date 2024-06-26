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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PostController {

    private final PostFactory postFactory;
    private String postData;

    @Autowired
    public PostController(PostFactory postFactory) {
        this.postFactory = postFactory;
    }

    @GetMapping("/createPost")
    public String showCreateForm(Model model) {
        model.addAttribute(postData, new PostData());
        return "post_new";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute("postData") PostData postData, Authentication authentication) {

        String author = authentication.getName() ;
        postData.setAuthor(author);
        Post post = postFactory.createPost(postData);
        postFactory.save(post);
        if (post.getId() != null) {
            return "redirect:/";
        } else {
            return "post_new";
        }
    }


    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model) {
        Optional<Post> optionalPost = postFactory.getById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            model.addAttribute("comment", new Comment());
            return "post";
        } else {
            optionalPost = postFactory.getByIdAccepted(id);
            if (optionalPost.isPresent()) {
                Post post = optionalPost.get();
                model.addAttribute("post", post);
                model.addAttribute("comment", new Comment());
                return "post";
            } else {
                return "home";
            }
        }
    }

    @GetMapping("/postsToAccept/{id}")
    public String getPostToAccept(@PathVariable Long id, Model model) {
        Optional<Post> optionalPost = postFactory.getById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "postToAccept";
        } else {
            optionalPost = postFactory.getByIdAccepted(id);
            if (optionalPost.isPresent()) {
                Post post = optionalPost.get();
                model.addAttribute("post", post);
                return "postToAccept";
            } else {
                return "home";
            }
        }
    }

    @PostMapping("/posts/{id}")
    public String addComment(@PathVariable Long id, @ModelAttribute("comment") Comment comment, Model model) {
        postFactory.addCommentToPost(id, comment);
        return "redirect:/posts/" + id;
    }
    
     @PostMapping("/posts/rating/{id}")
    public String addRating(@PathVariable Long id, @RequestParam double rating, Model model) {
        postFactory.addRatingToPost(id, rating);
        return "redirect:/posts/" + id;

    }
}

