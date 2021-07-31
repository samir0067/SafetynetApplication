package com.samir.safetynet;

import com.samir.safetynet.repository.SafetyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SafetynetApplication /*implements CommandLineRunner */{

	public static void main(String[] args) {
		SpringApplication.run(SafetynetApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		SafetyRepository.init();
//	}
}
