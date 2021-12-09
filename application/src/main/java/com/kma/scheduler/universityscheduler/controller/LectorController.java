package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.controller.requests.CreateLectorRequest;
import com.kma.scheduler.universityscheduler.entity.LectorEntity;
import com.kma.scheduler.universityscheduler.entity.Role;
import com.kma.scheduler.universityscheduler.service.admin.AdminService;
import com.kma.scheduler.universityscheduler.service.lector.LectorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("lector")
public class LectorController {
    private final AdminService adminService;
    private final LectorService lectorService;
    private final PasswordEncoder passwordEncoder;



    public LectorController(AdminService adminService, LectorService lectorService, PasswordEncoder passwordEncoder) {
        this.adminService = adminService;
        this.lectorService = lectorService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/all")
    public List<LectorEntity> getLectors() {
        return lectorService.getAllLectors();
    }

    @PostMapping("/add")
    @Secured({Role.MANAGER})
    @Operation(summary = "Create lector", security = @SecurityRequirement(name = "bearerAuth"))
    public String addLector(@Valid @RequestBody CreateLectorRequest request) {
        adminService.addLector(new LectorEntity(null, request.getName(), request.getLogin(), passwordEncoder.encode(request.getPassword()), request.getCathedra()));
        return "Added";
    }

    @DeleteMapping("/delete")
    @Secured({Role.MANAGER})
    @Operation(summary = "Delete lector", security = @SecurityRequirement(name = "bearerAuth"))
    public String deleteLector(@NotNull @RequestParam Long lectorId) {
        adminService.deleteLector(lectorId);
        return "Deleted";
    }
}
