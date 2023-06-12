package com.example.recipeswebsite.controller;

import com.example.recipeswebsite.model.Post;
import com.example.recipeswebsite.model.Search;
import com.example.recipeswebsite.services.PostFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RankingController {

    private final PostFactory postFactory;

    @Autowired
    public RankingController(PostFactory postFactory){
        this.postFactory = postFactory;
    }

    @GetMapping("/rank")
    public String getRanking(Model model){

        List<Post> postsSorted = postFactory.getAllAccepted().stream().sorted(Comparator.comparingDouble(Post::getAvgRating).reversed()).collect(Collectors.toList());
        model.addAttribute("recipes", postsSorted);
        model.addAttribute("ingr", new Search());
        return "recipesRanking";

    }

}
