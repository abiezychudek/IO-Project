package com.example.recipeswebsite.model;

import com.example.recipeswebsite.Factory.PostData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Post implements CategoryInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private double avgRating;
    private int numOfRatings;
    private String imgUrl;
    private double duration;
    private double difficulty;
    private double howManyPortions;
    private List<Categories> categories;
    private String description;

    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Post(PostData postData) {
        this.title = postData.getTitle();
        this.author = postData.getAuthor();
        this.avgRating = postData.getAvgRating();
        this.imgUrl = postData.getImgUrl();
        this.duration = postData.getDuration();
        this.difficulty = postData.getDifficulty();
        this.howManyPortions = postData.getHowManyPortions();
        this.description = postData.getDescription();
        this.comments = postData.getComments();
        this.createdAt = postData.getCreatedAt();
    }


}
