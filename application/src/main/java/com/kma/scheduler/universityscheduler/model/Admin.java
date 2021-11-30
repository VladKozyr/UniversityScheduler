package com.kma.scheduler.universityscheduler.model;

import com.kma.scheduler.universityscheduler.entity.Course;
import com.kma.scheduler.universityscheduler.service.lector.LectorService;
import com.kma.scheduler.universityscheduler.service.manager.ManagerService;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import com.kma.scheduler.universityscheduler.service.student.StudentService;

public class Admin extends User{
    private final ScheduleService scheduleService;
    private final StudentService studentService;
    private final LectorService lectorService;
    private final ManagerService managerService;

    public Admin(Long id, ScheduleService scheduleService, StudentService studentService, LectorService lectorService, ManagerService managerService, String name, String login){
        super(id, name, login);
        this.scheduleService = scheduleService;
        this.studentService = studentService;
        this.lectorService = lectorService;
        this.managerService = managerService;
    }

    public Student createStudent(String name,String login, Course course){
        return this.studentService.createStudent(name,login,course);
    }

    public Lector createLector(String name,String login){
        return this.lectorService.createLector(name,login);
    }

    public Manager createManager(String name,String login){
        return this.managerService.createManager(name,login);
    }
}
