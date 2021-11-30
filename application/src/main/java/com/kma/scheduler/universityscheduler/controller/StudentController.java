package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.controller.requests.CreateStudentRequest;
import com.kma.scheduler.universityscheduler.entity.Course;
import com.kma.scheduler.universityscheduler.entity.Role;
import com.kma.scheduler.universityscheduler.entity.StudentEntity;
import com.kma.scheduler.universityscheduler.exception.student.StudentNotFoundException;
import com.kma.scheduler.universityscheduler.service.admin.AdminService;
import com.kma.scheduler.universityscheduler.service.student.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("student")
public class StudentController {
    private final PasswordEncoder passwordEncoder;
    private final AdminService adminService;
    private final StudentService studentService;

    private Logger logger = LogManager.getLogger();

    public StudentController(PasswordEncoder passwordEncoder,AdminService adminService, StudentService studentService) {
        this.adminService = adminService;
        this.studentService = studentService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/all")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> list = studentService.getAllStudents();
        System.out.println(list);
        return list;
    }

    @PostMapping("/add")
    @Secured(Role.MANAGER)
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    public Long addStudent(@Valid @RequestBody CreateStudentRequest request) {
        System.out.println(request);
        StudentEntity studentEntity = new StudentEntity(null,request.getName(),request.getSurname(),passwordEncoder.encode(request.getPassword()),new Course(request.getCourseId(),0,null));
        adminService.addStudent(studentEntity);
        return studentEntity.getId();
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
