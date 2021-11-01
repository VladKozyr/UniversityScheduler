package com.kma.scheduler.universityscheduler.model;

import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;

public class Manager extends User{
    private final ScheduleService scheduleService;

    public Manager(Long id,ScheduleService scheduleService, String surname, String name){
        super(id, name, surname);
        this.scheduleService = scheduleService;
    }

    public void updateSchedule(Slot[] slots){
        for(Slot slot : slots)
            scheduleService.updateSlot(slot);
    }
}
