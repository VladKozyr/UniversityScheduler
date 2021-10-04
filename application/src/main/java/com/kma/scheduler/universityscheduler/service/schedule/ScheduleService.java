package com.kma.scheduler.universityscheduler.service.schedule;

import com.kma.scheduler.universityscheduler.model.Course;
import com.kma.scheduler.universityscheduler.model.Lector;
import com.kma.scheduler.universityscheduler.model.Slot;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    public Slot[] getCourseSchedule(Course course){
        return null;
    }

    public Slot[] getLectorSchedule(Lector lector){
        return null;
    }

    public Slot updateSlot(Slot slot){return slot;}
}
