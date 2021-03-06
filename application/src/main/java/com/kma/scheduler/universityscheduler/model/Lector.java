package com.kma.scheduler.universityscheduler.model;

import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;

public class Lector extends User {

    private final ScheduleService scheduleService;

    public Lector(Long id, ScheduleService scheduleService, String name, String login) {
        super(id, name, login);
        this.scheduleService = scheduleService;
    }

    public Slot[] getSchedule() {
        return scheduleService.getLectorSchedule(this);
    }

}
