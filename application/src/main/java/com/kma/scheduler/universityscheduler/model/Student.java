package com.kma.scheduler.universityscheduler.model;

import com.kma.scheduler.universityscheduler.entity.Course;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;

public class Student extends User {

    private final Course course;

    private final ScheduleService scheduleService;

    public Student(Long id,ScheduleService scheduleService, String surname, String name, Course course){
        super(id,name, surname);
        this.course = course;
        this.scheduleService = scheduleService;
    }

    public Slot[] getSchedule(){return scheduleService.getCourseSchedule(this.course);}
}
