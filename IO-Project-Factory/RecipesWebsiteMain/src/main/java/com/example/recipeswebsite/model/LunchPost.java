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
@Table(name = "lunch_post")
public class LunchPost extends Post {
    private boolean isFastMaking;

    public LunchPost(PostData postData) {
        super(postData);
        this.isFastMaking = postData.isFastMaking();
    }
}