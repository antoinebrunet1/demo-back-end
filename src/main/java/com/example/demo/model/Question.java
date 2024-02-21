package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

public record Question(@Id @JsonIgnore Integer id, String body, String category, Integer difficultyLevel, String author) {
}
