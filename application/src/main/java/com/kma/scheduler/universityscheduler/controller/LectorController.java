package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.entity.LectorEntity;
import com.kma.scheduler.universityscheduler.service.admin.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("lector")
public class LectorController {
    private final AdminService adminService;

    public LectorController(AdminService adminService) {
        this.adminService = adminService;
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
}
