package com.kma.scheduler.universityscheduler.service.manager;

import com.kma.scheduler.universityscheduler.model.Manager;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    private ScheduleService scheduleService;
    public ManagerService(ScheduleService scheduleService){
        this.scheduleService=scheduleService;
    }

    public Manager createManager(String name, String surname){
        return new Manager(scheduleService,name,surname);
    }
}
