package com.kma.scheduler.universityscheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {

    public static final String STUDENT = "ROLE_STUDENT";
    public static final String LECTOR = "ROLE_LECTOR";
    public static final String MANAGER = "ROLE_MANAGER";

    private String authority;

}