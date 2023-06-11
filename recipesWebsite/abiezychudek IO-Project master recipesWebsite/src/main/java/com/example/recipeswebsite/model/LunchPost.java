package com.example.recipeswebsite.Factory;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class LunchPost extends Post {
    private boolean isFastMaking;

    public LunchPost(PostData postData) {
        super(postData);
        this.isFastMaking = postData.isFastMaking();
    }
}
