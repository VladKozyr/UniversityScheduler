package com.kma.scheduler.universityscheduler.model;

import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import lombok.Getter;
import lombok.Setter;

public class Student {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter
    private int course;
    @Getter @Setter
    private String accessRole;
    @Getter
    private ScheduleService scheduleService;

    public Student(ScheduleService scheduleService, String surname, String name, int course, String accessRole){
        this.course = course;
        this.name = name;
        this.surname = surname;
        this.scheduleService = scheduleService;
        this.accessRole = accessRole;
    }
}
