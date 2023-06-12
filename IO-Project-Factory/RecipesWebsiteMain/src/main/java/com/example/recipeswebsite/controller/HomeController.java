package com.example.recipeswebsite.controller;

import com.example.recipeswebsite.model.CategoryInterface;
import com.example.recipeswebsite.model.Post;
import com.example.recipeswebsite.model.Search;
import com.example.recipeswebsite.services.PostFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class HomeController implements CategoryInterface {

    private final PostFactory postFactory;

    @Autowired
    public HomeController(PostFactory postFactory){
        this.postFactory = postFactory;
    }

    @GetMapping("/")
    public String home(Model model){

        List<Post> posts = postFactory.getAllAccepted();
        model.addAttribute("recipes", posts);
        model.addAttribute("ingr", new Search());
        return "home";

    }


}
