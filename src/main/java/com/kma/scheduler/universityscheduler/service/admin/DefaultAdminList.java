package com.kma.scheduler.universityscheduler.service.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        value="user.admin.isDefault",
        havingValue = "true",
        matchIfMissing = true)
public class DefaultAdminList {
    @Value("user.admin.name")
    public String adminName;
    @Value("user.admin.surname")
    public String adminSurname;
}
