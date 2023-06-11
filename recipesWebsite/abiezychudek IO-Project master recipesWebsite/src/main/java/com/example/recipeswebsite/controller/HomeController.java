package com.example.recipeswebsite.controller;

import com.example.recipeswebsite.model.CategoryInterface;
import com.example.recipeswebsite.model.Post;
import com.example.recipeswebsite.model.Search;
import com.example.recipeswebsite.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController implements CategoryInterface {

    private final PostService postService;

    @Autowired
    public HomeController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/")
    public String home(Model model){

        List<Post> posts = postService.getAll();
        model.addAttribute("recipes", posts);
        model.addAttribute("ingr", new Search());
        return "home";

    }

}
