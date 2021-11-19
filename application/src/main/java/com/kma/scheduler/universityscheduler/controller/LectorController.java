package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.entity.LectorEntity;
import com.kma.scheduler.universityscheduler.service.admin.AdminService;
import com.kma.scheduler.universityscheduler.service.lector.LectorService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("lector")
public class LectorController {
    private final AdminService adminService;
    private final LectorService lectorService;

    public LectorController(AdminService adminService, LectorService lectorService) {
        this.adminService = adminService;
        this.lectorService = lectorService;
    }

    @GetMapping("/all")
    public List<LectorEntity> getLectors() {
        return lectorService.getAllLectors();
    }

    @PostMapping("/add")
    public String addLector(@Valid @RequestBody LectorEntity lectorEntity) {
        adminService.addLector(lectorEntity);
        return "Added";
    }

    @DeleteMapping("/delete")
    public String deleteLector(@NotNull @RequestParam Long lectorId) {
        adminService.deleteLector(lectorId);
        return "Deleted";
    }
}
