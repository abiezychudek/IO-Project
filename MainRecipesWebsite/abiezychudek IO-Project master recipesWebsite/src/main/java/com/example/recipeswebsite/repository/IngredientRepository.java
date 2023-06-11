package com.example.recipeswebsite.repository;

import com.example.recipeswebsite.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
