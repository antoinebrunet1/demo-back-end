package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "QUESTIONS")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private int difficultyLevel;

    @Column(nullable = false)
    private String author;

}
