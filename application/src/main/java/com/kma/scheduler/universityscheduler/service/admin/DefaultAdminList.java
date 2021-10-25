package com.kma.scheduler.universityscheduler.service.admin;

import com.kma.scheduler.universityscheduler.model.Admin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        value="user.admin.isDefault",
        havingValue = "false",
        matchIfMissing = true)
public class DefaultAdminList implements AdminList {
    public String adminName = "default_name";
    public String adminSurname = "default_surname";
    private AdminService adminService;

    DefaultAdminList(AdminService adminService){
        this.adminService = adminService;
    }
    @Override
    public Admin getAdmin() {
        return this.adminService.createAdmin(adminName,adminSurname);
    }
}
