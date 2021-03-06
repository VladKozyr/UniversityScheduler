package com.kma.scheduler.universityscheduler.service.admin;

import com.kma.scheduler.universityscheduler.model.Admin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        value="user.admin.isDefault",
        havingValue = "true",
        matchIfMissing = false)
public class ConfiguredAdminList implements AdminList {
    @Value("${user.admin.name}")
    public String adminName;
    @Value("${user.admin.login}")
    public String adminlogin;
    private AdminService adminService;

    ConfiguredAdminList(AdminService adminService){
        this.adminService = adminService;
    }
    @Override
    public Admin getAdmin() {
        return this.adminService.createAdmin(adminName,adminlogin);
    }
}