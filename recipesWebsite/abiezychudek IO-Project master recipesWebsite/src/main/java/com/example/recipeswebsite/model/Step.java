package com.example.recipeswebsite.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "steps")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;
}
