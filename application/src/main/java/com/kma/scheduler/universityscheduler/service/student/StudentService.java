package com.kma.scheduler.universityscheduler.service.student;

import com.kma.scheduler.universityscheduler.model.Course;
import com.kma.scheduler.universityscheduler.model.Student;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private ScheduleService scheduleService;

    public Student createStudent(String name, String surname, Course course){
        return new Student(this.scheduleService, name,surname,course);
    }
}
