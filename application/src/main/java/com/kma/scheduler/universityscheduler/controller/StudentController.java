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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.persistence.PersistenceException;
import javax.validation.Valid;

@RestController
@RequestMapping("student")
@EnableScheduling
public class StudentController {
    private final PasswordEncoder passwordEncoder;
    private final AdminService adminService;
    private final StudentService studentService;

    private Logger logger = LogManager.getLogger();

    public StudentController(PasswordEncoder passwordEncoder, AdminService adminService, StudentService studentService) {
        this.adminService = adminService;
        this.studentService = studentService;
        this.passwordEncoder = passwordEncoder;
    }

    @Scheduled(fixedDelay = 1800000)
    public void scheduleStudentsCount(){
        logger.info("We have " + studentService.getAllStudents().size() + " students in database");
    }

    @Scheduled(cron = "0 * * * *")
    public void scheduleServiceWorks(){
        logger.info("Student service works");
    }
    @GetMapping("/all")
    @Secured({Role.MANAGER, Role.LECTOR})
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> list = studentService.getAllStudents();
        System.out.println(list);
        return list;
    }

    @PostMapping("/add")
    @Secured(Role.MANAGER)
    @Operation(summary = "Create student endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Long> addStudent(@Valid @RequestBody CreateStudentRequest request) {
        System.out.println(request);
        StudentEntity studentEntity = new StudentEntity(null, request.getName(), request.getLogin(), passwordEncoder.encode(request.getPassword()), new Course(request.getCourseId(), 0, null));
        adminService.addStudent(studentEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentEntity.getId());

    }

    @Secured(Role.MANAGER)
    @Operation(summary = "Delete student endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/delete")
    public StudentEntity deleteStudent(@RequestParam Long studentId) {
        Optional<StudentEntity> studentEntityOptional = adminService.deleteStudent(studentId);
        if (studentEntityOptional.isPresent()) {
            return studentEntityOptional.get();
        } else {
            throw new StudentNotFoundException();
        }
    }

    @Secured(Role.STUDENT)
    @GetMapping("/me")
    @Operation(summary = "Get self endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<StudentEntity> getSelf(){
        UserDetails principle = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return studentService.getStudent(principle.getUsername()).map(s->ResponseEntity.status(200).body(s)).orElseGet(()->ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND,
            reason = "Student not found")
    @ExceptionHandler(StudentNotFoundException.class)
    public void notFound() {
        logger.error("Student not found");
    }
}
