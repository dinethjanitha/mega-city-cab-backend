package com.example.megacitycabbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("CORS configuration applied"); // Add logging
        registry.addMapping("/**")
                // Allow all endpoints
                .allowedOrigins("http://localhost:3000")
                .allowedOriginPatterns("*")// Allow specific origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true) // Allow cookies and credentials
                .maxAge(3600); // Cache the preflight response for 1 hour
    }

}
