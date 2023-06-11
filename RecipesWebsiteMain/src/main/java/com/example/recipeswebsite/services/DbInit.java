package com.example.recipeswebsite.services;

import com.example.recipeswebsite.model.CategoryInterface;
import com.example.recipeswebsite.model.Comment;
import com.example.recipeswebsite.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner, CategoryInterface {

    private final PostService postService;

    private List<Categories> categories = new ArrayList<Categories>(Arrays.asList(Categories.values()));
    private List<Categories> categoriesTwo = new ArrayList<Categories>(Arrays.asList(Categories.POTATO, Categories.CARROT));
    private List<Categories> categoriesThree = new ArrayList<Categories>(Arrays.asList(Categories.SALT, Categories.PEPPER));

    private List<String> instructions = List.of(
            "Boil",
            "Stir",
            "Fry"
    );

    @Autowired
    public DbInit(PostService postService){
        this.postService = postService;
    }

    @Override
    public void run(String... args) throws Exception {
        postService.saveAll(List.of(
                new Post(null, "Ratatouille", "Edward Shchypka", 2.76, "https://posilkiwchorobie.pl/wp-content/uploads/2020/03/ratatouille.jpg", 2, 3, 4, categories, null, null, new ArrayList<Comment>(), null),
                new Post(null, "Pasta", "Juan Rosec", 3.5, "https://www.mojegotowanie.pl/media/cache/default_view/uploads/media/recipe/0002/35/danie-jednogarnkowe-z-makaronem.jpg", 2, 3, 4, categoriesThree, null, null, new ArrayList<Comment>(), null),
                new Post(null, "Lasagne", "Rafael Lavazza", 3.4, "https://ocdn.eu/pulscms-transforms/1/bsBk9kpTURBXy9lYjRkMjkyOTRiZDg5OWFhMzM2YTAwNzI5YjhjZTVlOS5qcGeTlQMAHs0D6M0CMpMFzQSwzQKkkwmmZDYyZmZiBt4AAaEwAQ/pasticcio.jpg", 2, 3, 4, categoriesTwo, null, null, new ArrayList<Comment>(), null),
                new Post(null, "Boczek", "Arthur Pole'anzki", 4.8, "https://staticsmaker.iplsc.com/smaker_production_2022_03_18/c4b0f3fbdefccc306c44697ac7b57c5f-lg.jpg", 4, 1, 3, new ArrayList<Categories>(Arrays.asList(Categories.CUCUMBER, Categories.PEPPER, Categories.ONION)), null, null, new ArrayList<Comment>(), null)
        ));
    }
}
