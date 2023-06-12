package com.example.recipeswebsite.services;

import com.example.recipeswebsite.Factory.PostData;
import com.example.recipeswebsite.model.CategoryInterface;
import com.example.recipeswebsite.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner, CategoryInterface {
    private final PostFactory postFactory;

    private List<Categories> categories = new ArrayList<Categories>(Arrays.asList(Categories.values()));
    private List<Categories> categoriesTwo = new ArrayList<Categories>(Arrays.asList(Categories.POTATO, Categories.CARROT));
    private List<Categories> categoriesThree = new ArrayList<Categories>(Arrays.asList(Categories.SALT, Categories.PEPPER));

    private List<String> instructions = List.of(
            "Boil",
            "Stir",
            "Fry"
    );

    @Autowired
    public DbInit(PostFactory postFactory){
        this.postFactory = postFactory;
    }

    @Override
    public void run(String... args) throws Exception {

        PostData postData1 = new PostData();
        postData1.setCategory("BREAKFAST");
        postData1.setTitle("Good Old-Fashioned Pancakes");
        postData1.setAuthor("John Doe");
        postData1.setImgUrl("https://www.allrecipes.com/thmb/XUxAXBMsoGtslJpRMgYeqQBjTZw=/750x0/filters:no_upscale():max_bytes(150000):strip_icc()/21014-Good-old-Fashioned-Pancakes-mfs_001-1fa26bcdedc345f182537d95b6cf92d8.jpg");
        postData1.setDuration(1.5);
        postData1.setDifficulty(2);
        postData1.setHowManyPortions(4);
        postData1.setDescription("Description of breakfast.");
        postData1.setVegetarian(true);

        PostData postData2 = new PostData();
        postData2.setCategory("Dessert");
        postData2.setTitle("Mini Pancake Parfait");
        postData2.setAuthor("John Doe");
        postData2.setImgUrl("https://www.allrecipes.com/thmb/N3RFvTuI4mRtKdVcxMfsRqRTIeU=/750x0/filters:no_upscale():max_bytes(150000):strip_icc()/7506803-mini-pancake-parfait-GOLDMAN-4x3-2488-9fc0d363ef1f49eaaa975b31705b747e.jpg");
        postData2.setDuration(1);
        postData2.setDifficulty(3);
        postData2.setHowManyPortions(4);
        postData2.setDescription("Description of dessert.");
        postData2.setSweetnessLevel(2);

        Post post1 = postFactory.createPost(postData1);
        Post post2 = postFactory.createPost(postData2);

    }
}