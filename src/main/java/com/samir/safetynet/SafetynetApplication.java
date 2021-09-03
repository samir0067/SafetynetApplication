package com.samir.safetynet;

import com.samir.safetynet.repository.JsonSafetyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SafetynetApplication{

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SafetynetApplication.class, args);
		JsonSafetyRepository.init();
	}
}
