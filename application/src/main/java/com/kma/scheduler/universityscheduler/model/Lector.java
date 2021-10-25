package com.kma.scheduler.universityscheduler.model;

import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;

import java.util.UUID;

public class Lector extends User {

    private final ScheduleService scheduleService;

    public Lector(UUID id, ScheduleService scheduleService, String name, String surname) {
        super(id, name, surname);
        this.scheduleService = scheduleService;
    }

    public Slot[] getSchedule() {
        return scheduleService.getLectorSchedule(this);
    }

}
