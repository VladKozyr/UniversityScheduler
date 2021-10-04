package com.kma.scheduler.jpacustomstarter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomJpaAutoConfiguration {
    @Bean
    String demoBean(){
        return "Hello Starter";
    }
}
