package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.entity.StudentEntity;
import com.kma.scheduler.universityscheduler.service.admin.AdminService;
import com.kma.scheduler.universityscheduler.service.student.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private final AdminService adminService;
    private final StudentService studentService;

    public StudentController(AdminService adminService, StudentService studentService) {
        this.adminService = adminService;
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> list = studentService.getAllStudents();
        System.out.println(list);
        return list;
    }

    @PostMapping("/add")
    public StudentEntity addStudent(@RequestBody StudentEntity studentEntity) {
        System.out.println(studentEntity);
        return adminService.addStudent(studentEntity);
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam Long studentId) {
        adminService.deleteStudent(studentId);
        return "Deleted";
    }
}
