package com.example.recipeswebsite.Factory;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class BreakfastPost extends Post {
    private boolean isVegetarian;

    public BreakfastPost(PostData postData) {
        super(postData);
        this.isVegetarian = postData.isVegetarian();
    }

}
