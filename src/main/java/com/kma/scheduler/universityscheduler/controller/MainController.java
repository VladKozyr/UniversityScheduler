package com.kma.scheduler.universityscheduler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/main")
    public String helloWorld() {
        return "Hello world!!!";
    }
}
