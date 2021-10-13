package com.kma.scheduler.universityscheduler.model;

import com.kma.scheduler.universityscheduler.entity.Course;
import com.kma.scheduler.universityscheduler.service.lector.LectorService;
import com.kma.scheduler.universityscheduler.service.manager.ManagerService;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import com.kma.scheduler.universityscheduler.service.student.StudentService;

import java.util.UUID;

public class Admin extends User{
    private final ScheduleService scheduleService;
    private final StudentService studentService;
    private final LectorService lectorService;
    private final ManagerService managerService;

    public Admin(UUID id, ScheduleService scheduleService, StudentService studentService, LectorService lectorService, ManagerService managerService, String name, String surname){
        super(id, name, surname);
        this.scheduleService = scheduleService;
        this.studentService = studentService;
        this.lectorService = lectorService;
        this.managerService = managerService;
    }

    public Student createStudent(String name,String surname, Course course){
        return this.studentService.createStudent(name,surname,course);
    }

    public Lector createLector(String name,String surname){
        return this.lectorService.createLector(name,surname);
    }

    public Manager createManager(String name,String surname){
        return this.managerService.createManager(name,surname);
    }
}
