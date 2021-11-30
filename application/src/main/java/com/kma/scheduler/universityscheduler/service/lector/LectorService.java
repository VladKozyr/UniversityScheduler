package com.kma.scheduler.universityscheduler.service.lector;

import com.kma.scheduler.universityscheduler.entity.LectorEntity;
import com.kma.scheduler.universityscheduler.model.Lector;
import com.kma.scheduler.universityscheduler.repository.LectorRepository;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LectorService {

    private final ScheduleService scheduleService;

    private final LectorRepository lectorRepository;

    public LectorService(ScheduleService scheduleService, LectorRepository repository) {
        this.scheduleService = scheduleService;
        this.lectorRepository = repository;
    }

    public Lector createLector(String name, String login) {
        return new Lector(null, scheduleService, name, login);
    }

    public List<LectorEntity> getAllLectors() {
        List<LectorEntity> list = new ArrayList<>();
        lectorRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
