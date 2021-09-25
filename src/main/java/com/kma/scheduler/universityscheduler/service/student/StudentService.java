package com.kma.scheduler.universityscheduler.service.student;

import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private ScheduleService scheduleService;
}
