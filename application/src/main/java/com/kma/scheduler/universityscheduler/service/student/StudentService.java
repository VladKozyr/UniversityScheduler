package com.kma.scheduler.universityscheduler.service.student;

import com.kma.scheduler.universityscheduler.entity.Course;
import com.kma.scheduler.universityscheduler.entity.StudentEntity;
import com.kma.scheduler.universityscheduler.entity.slot.SlotEntity;
import com.kma.scheduler.universityscheduler.model.Student;
import com.kma.scheduler.universityscheduler.repository.StudentRepository;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class StudentService {

    private final ScheduleService scheduleService;
    private final StudentRepository studentRepository;

    public StudentService(ScheduleService scheduleService, StudentRepository studentRepository) {
        this.scheduleService = scheduleService;
        this.studentRepository = studentRepository;
    }

    public Student createStudent(String name, String login, Course course) {
        return new Student(null, this.scheduleService, name, login, course);
    }

    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> list = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public List<SlotEntity> getSlotsByFaculty(StudentEntity student){
        return scheduleService.getSlotByFaculty(student.getCourse().getFaculty());
    }


    @Cacheable(value = "student-cache", key = "#login")
    public Optional<StudentEntity> getStudent(String login) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return studentRepository.findStudentByLogin(login);
    }

    @CacheEvict(value = "student-cache", allEntries = true)
    public void evictAllCacheValues() {}

}
