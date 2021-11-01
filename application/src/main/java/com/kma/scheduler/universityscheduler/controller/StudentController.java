package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.entity.StudentEntity;
import com.kma.scheduler.universityscheduler.exception.student.StudentNotFoundException;
import com.kma.scheduler.universityscheduler.service.admin.AdminService;
import com.kma.scheduler.universityscheduler.service.student.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("student")
public class StudentController {
    private final AdminService adminService;
    private final StudentService studentService;

    private Logger logger = LogManager.getLogger();

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
    public StudentEntity addStudent(@Valid @RequestBody StudentEntity studentEntity) {
        System.out.println(studentEntity);
        return adminService.addStudent(studentEntity);
    }

    @DeleteMapping("/delete")
    public StudentEntity deleteStudent(@RequestParam Long studentId) {
        Optional<StudentEntity> studentEntityOptional = adminService.deleteStudent(studentId);
        if(studentEntityOptional.isPresent()){
            return studentEntityOptional.get();
        }else{
            throw new StudentNotFoundException();
        }
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND,
            reason="Student not found")
    @ExceptionHandler(StudentNotFoundException.class)
    public void notFound() {
        logger.error("Student not found");
    }
}
