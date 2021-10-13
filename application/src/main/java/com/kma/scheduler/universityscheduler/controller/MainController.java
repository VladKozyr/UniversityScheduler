package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.entity.LectorEntity;
import com.kma.scheduler.universityscheduler.entity.StudentEntity;
import com.kma.scheduler.universityscheduler.service.admin.AdminList;
import com.kma.scheduler.universityscheduler.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    AdminService adminService;

    MainController(String demo, AdminList adminList){
        System.out.println(demo);
        System.out.println(adminList.getAdmin());
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody StudentEntity studentEntity){
        adminService.addStudent(studentEntity);
        return "Added";
    }

    @PostMapping("/addLector")
    public String addLector(@RequestBody LectorEntity lectorEntity){
        adminService.addLector(lectorEntity);
        return "Added";
    }


}
