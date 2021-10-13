package com.kma.scheduler.universityscheduler.service.lector;

import com.kma.scheduler.universityscheduler.model.Lector;
import com.kma.scheduler.universityscheduler.repository.LectorRepository;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectorService {

    private final ScheduleService scheduleService;

    private final LectorRepository repository;

    public LectorService(ScheduleService scheduleService, LectorRepository repository) {
        this.scheduleService = scheduleService;
        this.repository = repository;
    }

    public Lector createLector(String name, String surname){
        return new Lector(null, scheduleService,name,surname);
    }
}
