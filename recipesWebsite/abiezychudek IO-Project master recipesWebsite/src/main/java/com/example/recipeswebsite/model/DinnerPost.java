package com.example.recipeswebsite.Factory;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class DinnerPost extends Post {
    private boolean isLightweight;

    public DinnerPost(PostData postData) {
        super(postData);
        this.isLightweight = postData.isLightweight();
    }
}
