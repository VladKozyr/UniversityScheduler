package com.kma.scheduler.universityscheduler.model;

import com.kma.scheduler.universityscheduler.service.role.RoleService;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import lombok.Getter;
import lombok.Setter;

public class Admin extends Human{
    @Getter @Setter
    private String accessRole;
    @Getter
    private ScheduleService scheduleService;
    @Getter
    private RoleService roleService;

    public Admin(ScheduleService scheduleService,RoleService roleService, String surname, String name, String department, String accessRole){
        super(name, surname);
        this.scheduleService = scheduleService;
        this.accessRole = accessRole;
        this.roleService = roleService;
    }

    public void setRole(int userId, RoleService.Role role){roleService.setRole(userId, role);}
    public void removeRole(int userId){roleService.removeRole(userId);}
}
