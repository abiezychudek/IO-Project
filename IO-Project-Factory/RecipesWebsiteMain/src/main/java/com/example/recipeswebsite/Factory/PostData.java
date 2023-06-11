package com.example.recipeswebsite.Factory;

import com.example.recipeswebsite.model.Comment;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class PostData {
    private String category;
    private String title;
    private String author;
    private double avgRating;
    private int numOfRatings;
    private String imgUrl;
    private double duration;
    private double difficulty;
    private double howManyPortions;
    private String description;
    private Date createdAt;
    private int sweetnessLevel; //desert
    private boolean isVegetarian; //breakfast
    private boolean isFastMaking; //lunch
    private boolean isLightweight; //dinner
    private List<Comment> comments;


}
