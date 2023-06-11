package com.example.recipeswebsite.model;

import com.example.recipeswebsite.Factory.PostData;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "dinner_post")
public class DinnerPost extends Post {
    private boolean isLightweight;

    public DinnerPost(PostData postData) {
        super(postData);
        this.isLightweight = postData.isLightweight();
    }
}
