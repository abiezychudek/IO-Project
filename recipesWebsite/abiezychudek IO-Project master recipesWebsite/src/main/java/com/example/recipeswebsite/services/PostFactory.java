package com.example.recipeswebsite.model;

import com.example.recipeswebsite.Factory.PostData;
import org.springframework.stereotype.Service;

@Service
public class PostFactory {

    public Post createPost(PostData postData) {
        String category = postData.getCategory();
        if (category == null) {
            return null;
        }
        if (category.equalsIgnoreCase("DESSERT")) {
            DessertPost dessertPost = new DessertPost(postData);
            dessertPost.setSweetnessLevel(postData.getSweetnessLevel());
            return dessertPost;
        } else if (category.equalsIgnoreCase("BREAKFAST")) {
            BreakfastPost breakfastPost = new BreakfastPost(postData);
            breakfastPost.setVegetarian(postData.isVegetarian());
            return breakfastPost;
        } else if (category.equalsIgnoreCase("LUNCH")) {
            LunchPost lunchPost = new LunchPost(postData);
            lunchPost.setFastMaking(postData.isFastMaking());
            return lunchPost;
        } else if (category.equalsIgnoreCase("DINNER")) {
            DinnerPost dinnerPost = new DinnerPost(postData);
            dinnerPost.setLightweight(postData.isLightweight());
            return dinnerPost;
        }
        return null;
    }
}
