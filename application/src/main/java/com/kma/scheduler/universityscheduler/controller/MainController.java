package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.service.admin.AdminList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    MainController(String demo, AdminList adminList){
        System.out.println(demo);
        System.out.println(adminList.getAdmin());
    }
    @GetMapping("/main")
    public String helloWorld() {
        return "Hello world!!!";
    }
}
