package com.kma.scheduler.universityscheduler.service.admin;

import com.kma.scheduler.universityscheduler.entity.LectorEntity;
import com.kma.scheduler.universityscheduler.entity.StudentEntity;
import com.kma.scheduler.universityscheduler.exception.student.StudentNotFoundException;
import com.kma.scheduler.universityscheduler.model.Admin;
import com.kma.scheduler.universityscheduler.repository.LectorRepository;
import com.kma.scheduler.universityscheduler.repository.StudentRepository;
import com.kma.scheduler.universityscheduler.service.lector.LectorService;
import com.kma.scheduler.universityscheduler.service.manager.ManagerService;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import com.kma.scheduler.universityscheduler.service.student.StudentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    private final ScheduleService scheduleService;
    private final StudentService studentService;
    private final LectorService lectorService;
    private final ManagerService managerService;

    private final StudentRepository studentRepository;
    private final LectorRepository lectorRepository;

    public AdminService(ScheduleService scheduleService, StudentService studentService, LectorService lectorService, ManagerService managerService, StudentRepository studentRepository, LectorRepository lectorRepository) {
        this.scheduleService = scheduleService;
        this.studentService = studentService;
        this.lectorService = lectorService;
        this.managerService = managerService;
        this.studentRepository = studentRepository;
        this.lectorRepository = lectorRepository;
    }


    public Admin createAdmin(String name, String surname) {
        return new Admin(null, scheduleService, studentService, lectorService, managerService, name, surname);
    }

    public StudentEntity addStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public Optional<StudentEntity> deleteStudent(Long studentId) {
        return studentRepository.findById(studentId).map(s->{studentRepository.delete(s); return s;});
    }

    public void addLector(LectorEntity lectorEntity) {
        lectorRepository.save(lectorEntity);
    }

    public void deleteLector(Long lectorId) {
        lectorRepository.deleteById(lectorId);
    }
}
