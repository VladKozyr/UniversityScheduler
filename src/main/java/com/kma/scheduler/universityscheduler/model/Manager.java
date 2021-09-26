package com.kma.scheduler.universityscheduler.model;

import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import lombok.Getter;
import lombok.Setter;

public class Manager extends Human{
    @Getter @Setter
    private String accessRole;
    @Getter
    private ScheduleService scheduleService;

    public Manager(ScheduleService scheduleService, String surname, String name, String department, String accessRole){
        super(name, surname);
        this.scheduleService = scheduleService;
        this.accessRole = accessRole;
    }

    public void updateSchedule(int personId, Slot[] slots){
        for(Slot slot : slots)
            scheduleService.updateSchedule(personId, slot);
    }
}
