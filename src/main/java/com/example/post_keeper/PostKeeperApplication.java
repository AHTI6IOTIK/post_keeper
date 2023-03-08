package com.example.post_keeper;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class PostKeeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostKeeperApplication.class, args);
	}

}
