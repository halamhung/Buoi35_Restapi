package com.example.baitap.config;

import com.example.baitap.service.ManualGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ManualGreetingService manualGreetingService() {
        return new ManualGreetingService();
    }
}