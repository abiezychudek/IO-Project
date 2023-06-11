package com.example.recipeswebsite.model;

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
public class Post implements CategoryInterface {

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
    private List<Categories> categories;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="ingredient_id", referencedColumnName = "id", nullable = false)
    private List<Ingredient> ingredients;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="step_id", referencedColumnName = "id", nullable = false)
    private List<Step> instructions;

    private Date createdAt;

    /*@NotNull
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;*/




}
