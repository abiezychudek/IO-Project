package com.example.recipeswebsite.Factory;

import lombok.Data;
import java.util.Date;

@Data
public class PostData {
    private String category;
    private String title;
    private String author;
    private double avgRating;
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


}

