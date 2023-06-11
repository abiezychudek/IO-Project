package com.example.recipeswebsite.model;

import com.example.recipeswebsite.Factory.PostData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private double avgRating;
    private String imgUrl;
    private double duration;
    private double difficulty;
    private double howManyPortions;
//    private List<Categories> categories;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    /*@NotNull
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;*/

    public Post(PostData postData) {
        this.title = postData.getTitle();
        this.author = postData.getAuthor();
        this.avgRating = postData.getAvgRating();
        this.imgUrl = postData.getImgUrl();
        this.duration = postData.getDuration();
        this.difficulty = postData.getDifficulty();
        this.howManyPortions = postData.getHowManyPortions();
        this.description = postData.getDescription();
        this.createdAt = postData.getCreatedAt();
    }

}
