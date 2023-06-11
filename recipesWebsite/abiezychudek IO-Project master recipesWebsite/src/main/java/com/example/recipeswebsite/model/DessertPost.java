package com.example.recipeswebsite.Factory;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class DessertPost extends Post {
    private int sweetnessLevel;

    public DessertPost(PostData postData) {
        super(postData);
        this.sweetnessLevel = postData.getSweetnessLevel();
    }
}



