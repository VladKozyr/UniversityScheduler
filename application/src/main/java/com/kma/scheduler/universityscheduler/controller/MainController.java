package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.Entity.UserEntity;
import com.kma.scheduler.universityscheduler.service.admin.AdminList;
import com.kma.scheduler.universityscheduler.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    AdminService adminService;

    MainController(String demo, AdminList adminList){
        System.out.println(demo);
        System.out.println(adminList.getAdmin());
    }
    @GetMapping("/main")
    public String helloWorld() {
        return "Hello world!!!";
    }

    @GetMapping("/post")
    public String addNew(){
        adminService.save(new UserEntity("Stas", "Bohuta", "student"));
        return "Added";}
}
