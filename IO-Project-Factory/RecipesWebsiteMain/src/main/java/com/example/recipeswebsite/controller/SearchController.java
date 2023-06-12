package com.example.recipeswebsite.controller;

import com.example.recipeswebsite.model.CategoryInterface;
import com.example.recipeswebsite.model.Post;
import com.example.recipeswebsite.model.Search;
import com.example.recipeswebsite.services.PostFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class SearchController {

    private final PostFactory postFactory;

    @Autowired
    public SearchController(PostFactory postFactory){
        this.postFactory = postFactory;
    }

    @PostMapping("/")
    public String search(@ModelAttribute("ingr") Search searchedIngredients, Model model){

        List<Post> posts = postFactory.getAllAccepted();
        Collections.reverse(posts);
        List<Post> postsOutput = new ArrayList<Post>();

        if(searchedIngredients.getIngrdts() != null){

            List <CategoryInterface.Categories> ingList = List.of(searchedIngredients.getIngrdts());

            for (Post p : posts){
                if(p.getCategories() != null){
                    for(CategoryInterface.Categories i : p.getCategories()){
                        if(ingList.contains(i)){
                            postsOutput.add(p);
                            break;
                        }
                    }
                }

            }

        } else if(!searchedIngredients.getName().equals("")){

            postsOutput = posts.stream().filter(p -> p.getTitle().contains(searchedIngredients.getName())).toList();

        }

        model.addAttribute("recipes", postsOutput);
        model.addAttribute("ingr", searchedIngredients);
        return "search";

    }

}
