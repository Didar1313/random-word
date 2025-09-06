package com.example.randomword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RandomWordApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomWordApplication.class, args);
	}

}
