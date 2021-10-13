package com.kma.scheduler.universityscheduler.service.student;

import com.kma.scheduler.universityscheduler.entity.Course;
import com.kma.scheduler.universityscheduler.model.Student;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private ScheduleService scheduleService;

    public StudentService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    public Student createStudent(String name, String surname, Course course){
        return new Student(null,this.scheduleService, name,surname,course);
    }
}
