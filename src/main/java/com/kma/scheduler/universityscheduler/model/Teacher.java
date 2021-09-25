package com.kma.scheduler.universityscheduler.model;

import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import lombok.Getter;
import lombok.Setter;

public class Teacher {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter
    private String department;
    @Getter @Setter
    private String accessRole;
    @Getter
    private ScheduleService scheduleService;

    public Teacher(ScheduleService scheduleService, String surname, String name, String department, String accessRole){
        this.name = name;
        this.surname = surname;
        this.scheduleService = scheduleService;
        this.department = department;
        this.accessRole = accessRole;
    }


}
