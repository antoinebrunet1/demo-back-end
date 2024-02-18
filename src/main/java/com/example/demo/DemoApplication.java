package com.example.demo;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(QuestionRepository questionRepository) {
		return args -> {
			questionRepository.save(new Question(null, "What is the capital of Canada?", 0, "Antoine Brunet"));
			questionRepository.save(new Question(null, "What is the capital of Ontario?", 1, "Antoine Brunet"));
		};
	}
}
