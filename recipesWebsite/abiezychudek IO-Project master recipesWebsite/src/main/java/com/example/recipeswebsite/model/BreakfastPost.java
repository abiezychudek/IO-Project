package com.example.recipeswebsite.model;

import com.example.recipeswebsite.Factory.PostData;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Data
@Table(name = "breakfast_post")
public class BreakfastPost extends Post {
    private boolean isVegetarian;

    public BreakfastPost(PostData postData) {
        super(postData);
        this.isVegetarian = postData.isVegetarian();
    }

}
