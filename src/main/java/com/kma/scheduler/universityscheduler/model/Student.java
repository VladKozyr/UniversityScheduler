package com.kma.scheduler.universityscheduler.model;

import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import lombok.Getter;
import lombok.Setter;

public class Student extends User {

    private final Course course;

    private final ScheduleService scheduleService;

    public Student(ScheduleService scheduleService, String surname, String name, Course course){
        super(name, surname);
        this.course = course;
        this.scheduleService = scheduleService;
    }

    public Slot[] getSchedule(){return scheduleService.getCourseSchedule(this.course);}
}
