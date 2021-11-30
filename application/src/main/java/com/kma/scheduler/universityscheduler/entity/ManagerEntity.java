package com.kma.scheduler.universityscheduler.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name="manager")
public class ManagerEntity extends UserEntity {
    private static final Logger logger = LogManager.getLogger(ManagerEntity.class);

    public ManagerEntity(Long id, String name, String login,String  password) {
        super(id, name, login,password,Role.MANAGER);
        ThreadContext.put("name", name);
        ThreadContext.put("login", login);
        logger.info("Manager created");
        ThreadContext.clearAll();
    }
}
