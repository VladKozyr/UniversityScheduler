package com.kma.scheduler.universityscheduler.service.admin;

import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final ScheduleService scheduleService;

    public AdminService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
}
