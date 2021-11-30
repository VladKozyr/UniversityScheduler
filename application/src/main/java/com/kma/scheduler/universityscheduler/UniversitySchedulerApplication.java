package com.kma.scheduler.universityscheduler;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@SecurityScheme(name = "javainuseapi", scheme = "bearerAuth", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class UniversitySchedulerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UniversitySchedulerApplication.class, args);
        LogManager.getLogger(UniversitySchedulerApplication.class).info("Application started");
    }
}
