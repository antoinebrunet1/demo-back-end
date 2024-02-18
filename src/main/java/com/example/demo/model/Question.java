package com.example.demo.model;

import org.springframework.data.annotation.Id;

public record Question(@Id Integer id, String body, Integer difficultyLevel, String author) {
}
