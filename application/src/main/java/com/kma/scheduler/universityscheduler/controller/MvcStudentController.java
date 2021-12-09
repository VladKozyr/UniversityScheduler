package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.controller.mapping.StudentAddMapping;
import com.kma.scheduler.universityscheduler.entity.Course;
import com.kma.scheduler.universityscheduler.entity.Role;
import com.kma.scheduler.universityscheduler.entity.StudentEntity;
import com.kma.scheduler.universityscheduler.repository.CourseRepository;
import com.kma.scheduler.universityscheduler.service.admin.AdminService;
import com.kma.scheduler.universityscheduler.service.student.StudentService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mvc")
public class MvcStudentController {

    private final StudentService studentService;
    private final PasswordEncoder passwordEncoder;
    private final CourseRepository courseRepository;
    private final AdminService adminService;

    public MvcStudentController(StudentService studentService, PasswordEncoder passwordEncoder, CourseRepository courseRepository, AdminService adminService) {
        this.studentService = studentService;
        this.passwordEncoder = passwordEncoder;
        this.courseRepository = courseRepository;
        this.adminService = adminService;
    }

    @Secured({Role.MANAGER})
    @RequestMapping("/student/add")
    public String addStudent(Model model) {

        List<Course> courseList = new ArrayList<>();
        courseRepository.findAll().iterator().forEachRemaining(courseList::add);

        model.addAttribute("student", new StudentAddMapping());
        model.addAttribute("courses", courseList);

        return "student/add";
    }

    @Secured({Role.MANAGER})
    @PostMapping("/student/create")
    public String createStudent(@ModelAttribute StudentAddMapping studentMapping) {
        try {
            StudentEntity studentEntity = new StudentEntity(
                    null,
                    studentMapping.getStudentName(),
                    studentMapping.getLogin(), passwordEncoder.encode(studentMapping.getPassword()),
                    new Course(studentMapping.getCourseId(), 0, null));
            adminService.addStudent(studentEntity);
            return "redirect:/main";
        } catch (Exception e) {
            return "redirect:/index";
        }
    }
}
