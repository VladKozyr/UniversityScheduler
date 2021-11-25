package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.service.admin.AdminList;
import com.kma.scheduler.universityscheduler.service.admin.AdminService;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
