package com.kma.scheduler.universityscheduler;

import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class UniversitySchedulerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UniversitySchedulerApplication.class, args);
//        LogManager.getLogger(UniversitySchedulerApplication.class).info("Application started");
    }

}
