package com.example.recipeswebsite.model;

import com.example.recipeswebsite.Factory.PostData;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "dessert_post")
public class DessertPost extends Post {
    private int sweetnessLevel;

    public DessertPost(PostData postData) {
        super(postData);
        this.sweetnessLevel = postData.getSweetnessLevel();
    }
}
