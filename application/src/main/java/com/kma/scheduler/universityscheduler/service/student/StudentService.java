package com.kma.scheduler.universityscheduler.service.student;

import com.kma.scheduler.universityscheduler.entity.Course;
import com.kma.scheduler.universityscheduler.entity.StudentEntity;
import com.kma.scheduler.universityscheduler.model.Student;
import com.kma.scheduler.universityscheduler.repository.StudentRepository;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final ScheduleService scheduleService;
    private final StudentRepository studentRepository;

    public StudentService(ScheduleService scheduleService, StudentRepository studentRepository) {
        this.scheduleService = scheduleService;
        this.studentRepository = studentRepository;
    }

    public Student createStudent(String name, String surname, Course course) {
        return new Student(null, this.scheduleService, name, surname, course);
    }

    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> list = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(s -> {
            list.add(s);
        });
        return list;
    }
}
