package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.entity.LectorEntity;
import com.kma.scheduler.universityscheduler.entity.StudentEntity;
import com.kma.scheduler.universityscheduler.service.admin.AdminList;
import com.kma.scheduler.universityscheduler.service.admin.AdminService;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class MainController {
    private final AdminService adminService;
    private final ScheduleService scheduleService;

    MainController(String demo, AdminList adminList, AdminService adminService, ScheduleService scheduleService) {
        this.adminService = adminService;
        this.scheduleService = scheduleService;
        System.out.println(demo);
        System.out.println(adminList.getAdmin());
    }

    @GetMapping("/main")
    public String main() {
        return "Main controller";
    }

    @PostMapping("/student/add")
    public String addStudent(@RequestBody StudentEntity studentEntity) {
        adminService.addStudent(studentEntity);
        return "Added";
    }

    @DeleteMapping("/student/delete")
    public String deleteStudent(@RequestParam UUID studentUUID) {
        adminService.deleteStudent(studentUUID);
        return "Deleted";
    }

    @PostMapping("/lector/add")
    public String addLector(@RequestBody LectorEntity lectorEntity) {
        adminService.addLector(lectorEntity);
        return "Added";
    }

    @DeleteMapping("/lector/delete")
    public String addLector(@RequestParam UUID lectorUUID) {
        adminService.deleteLector(lectorUUID);
        return "Deleted";
    }


    @PutMapping("timeslot/update")
    public String updateTimeslot(@RequestParam UUID slotUUID, UUID lectorUUID, UUID courseUUID) {
        scheduleService.updateSlot(slotUUID, lectorUUID, courseUUID);
        return "Updated";
    }

}
