package com.kma.scheduler.universityscheduler.service.schedule;

import com.kma.scheduler.universityscheduler.entity.Course;
import com.kma.scheduler.universityscheduler.model.Lector;
import com.kma.scheduler.universityscheduler.model.Slot;
import com.kma.scheduler.universityscheduler.repository.SlotRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private final SlotRepository repository;

    public ScheduleService(SlotRepository repository) {
        this.repository = repository;
    }

    public Slot[] getCourseSchedule(Course course){
        return null;
    }

    public Slot[] getLectorSchedule(Lector lector){
        return null;
    }

    public Slot updateSlot(Slot slot){return slot;}


}
