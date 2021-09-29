package com.kma.scheduler.universityscheduler.service.lector;

import com.kma.scheduler.universityscheduler.model.Lector;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectorService {

    private ScheduleService scheduleService;

    @Autowired
    public void setScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    public Lector createLector(String name, String surname){
        return new Lector(scheduleService,name,surname);
    }
}
