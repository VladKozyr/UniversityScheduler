package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.controller.mapping.LectorAddMapping;
import com.kma.scheduler.universityscheduler.controller.mapping.StudentAddMapping;
import com.kma.scheduler.universityscheduler.entity.Course;
import com.kma.scheduler.universityscheduler.entity.LectorEntity;
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
public class MvcLectorController {

    private final StudentService studentService;
    private final PasswordEncoder passwordEncoder;
    private final CourseRepository courseRepository;
    private final AdminService adminService;

    public MvcLectorController(StudentService studentService, PasswordEncoder passwordEncoder, CourseRepository courseRepository, AdminService adminService) {
        this.studentService = studentService;
        this.passwordEncoder = passwordEncoder;
        this.courseRepository = courseRepository;
        this.adminService = adminService;
    }

    @Secured({Role.MANAGER})
    @RequestMapping("/lector/add")
    public String addLector(Model model) {

        model.addAttribute("lector", new LectorAddMapping());

        return "lector/add";
    }

    @Secured({Role.MANAGER})
    @PostMapping("/lector/create")
    public String createLector(@ModelAttribute LectorAddMapping lectorAddMapping) {
        try {
            LectorEntity lectorEntity = new LectorEntity(
                    null,
                    lectorAddMapping.getLectorName(),
                    lectorAddMapping.getLogin(), passwordEncoder.encode(lectorAddMapping.getPassword()),
                    lectorAddMapping.getCathedra());
            adminService.addLector(lectorEntity);
            return "redirect:/main";
        } catch (Exception e) {
            return "redirect:/index";
        }
    }
}

