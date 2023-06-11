package com.example.recipeswebsite.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Search implements CategoryInterface {
    public Categories[] ingrdts;
    public String name;
}
