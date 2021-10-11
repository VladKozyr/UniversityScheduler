package com.kma.scheduler.universityscheduler.service.admin;

import com.kma.scheduler.universityscheduler.Entity.UserEntity;
import com.kma.scheduler.universityscheduler.model.Admin;
import com.kma.scheduler.universityscheduler.repository.UserRepository;
import com.kma.scheduler.universityscheduler.service.lector.LectorService;
import com.kma.scheduler.universityscheduler.service.manager.ManagerService;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import com.kma.scheduler.universityscheduler.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final ScheduleService scheduleService;
    private final StudentService studentService;
    private final LectorService lectorService;
    private final ManagerService managerService;

    @Autowired
    UserRepository userRepository;

    public void save(UserEntity userEntity){
        userRepository.save(userEntity);
    }
    public AdminService(ScheduleService scheduleService, StudentService studentService, LectorService lectorService, ManagerService managerService) {
        this.scheduleService = scheduleService;
        this.studentService = studentService;
        this.lectorService = lectorService;
        this.managerService = managerService;
    }

    public Admin createAdmin(String name, String surname){
        return new Admin(scheduleService,studentService,lectorService,managerService,name,surname);
    }
}
