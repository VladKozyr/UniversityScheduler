package com.kma.scheduler.universityscheduler.service.role;

import com.kma.scheduler.universityscheduler.model.Slot;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    public enum Role{ADMIN, READER, MANAGER}
    public void setRole(int userId, Role role){}
    public Role getRole(int userId){return null;}
    public void removeRole(int userId){}
}
