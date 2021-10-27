package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.entity.StudentEntity;
import com.kma.scheduler.universityscheduler.service.admin.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("student")
public class StudentController {
    private final AdminService adminService;

    public StudentController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentEntity studentEntity) {
        adminService.addStudent(studentEntity);
        return "Added";
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam UUID studentUUID) {
        adminService.deleteStudent(studentUUID);
        return "Deleted";
    }
}
