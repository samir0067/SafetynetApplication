package com.samir.safetynet;

import com.samir.safetynet.repository.SafetyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;

@SpringBootApplication
public class SafetynetApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SafetynetApplication.class, args);
		SafetyRepository.init();
    }
}
