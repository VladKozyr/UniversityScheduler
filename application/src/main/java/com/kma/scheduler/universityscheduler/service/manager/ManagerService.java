package com.kma.scheduler.universityscheduler.service.manager;

import com.kma.scheduler.universityscheduler.entity.slot.SlotEntity;
import com.kma.scheduler.universityscheduler.model.Manager;
import com.kma.scheduler.universityscheduler.repository.ManagerRepository;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    private final ScheduleService scheduleService;
    private final ManagerRepository repository;

    public ManagerService(ScheduleService scheduleService, ManagerRepository repository) {
        this.scheduleService = scheduleService;
        this.repository = repository;
    }

    public Manager createManager(String name, String login){
        return new Manager(null,scheduleService,name,login);
    }

    public List<SlotEntity> getSchedule(){
        return scheduleService.getAllSlots();
    }
}
