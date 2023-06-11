package com.example.recipeswebsite.repository;

import com.example.recipeswebsite.model.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Step, Long> {
}
