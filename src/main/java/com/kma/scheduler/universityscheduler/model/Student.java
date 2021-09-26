package com.kma.scheduler.universityscheduler.model;

import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import lombok.Getter;
import lombok.Setter;

public class Student extends Human {

    @Getter @Setter
    private int course;
    @Getter @Setter
    private String accessRole;
    @Getter
    private ScheduleService scheduleService;


    public Student(ScheduleService scheduleService, String surname, String name, int course, String accessRole){
        super(name, surname);
        this.course = course;
        this.scheduleService = scheduleService;
        this.accessRole = accessRole;
    }

    public Slot[] readSchedule(){return scheduleService.getSchedule(id);}
}
