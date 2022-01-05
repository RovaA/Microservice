package com.example.democlient.openfeign;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OpenFeignConfiguration {

    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
