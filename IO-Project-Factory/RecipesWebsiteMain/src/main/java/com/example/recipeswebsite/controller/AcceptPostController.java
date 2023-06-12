package com.example.recipeswebsite.controller;

import com.example.recipeswebsite.model.Post;
import com.example.recipeswebsite.services.PostFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class AcceptPostController {

    private final PostFactory postFactory;

    public AcceptPostController(PostFactory postFactory) {
        this.postFactory = postFactory;
    }

    @GetMapping("/admin/accept")
    public String getPostsToAccept(Model model){

        List<Post> postsToAccept = postFactory.getAll();
        model.addAttribute("postsToAccept", postsToAccept);
        return "accept";

    }

    @PostMapping(value = "/admin/accept", params = "action=accept")
    public String accept(@RequestParam Long id){

        Optional<Post> optionalPost = postFactory.getById(id);
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            postFactory.delete(post);
            postFactory.saveAccepted(post);
            return "redirect:/admin/accept";
        } else {
            return "home";
        }

    }

    @PostMapping(value = "/admin/accept", params = "action=deny")
    public String deny(@RequestParam Long id){

        Optional<Post> optionalPost = postFactory.getById(id);
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            postFactory.delete(post);
            return "redirect:/admin/accept";
        } else {
            return "home";
        }

    }


}
