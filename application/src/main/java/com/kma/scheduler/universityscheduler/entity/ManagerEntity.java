package com.kma.scheduler.universityscheduler.entity;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="manager")
public class ManagerEntity extends UserEntity {
    private static final Logger logger = LogManager.getLogger(ManagerEntity.class);

    public ManagerEntity(UUID id, String name, String surname) {
        super(id, name, surname);
        ThreadContext.put("name", name);
        ThreadContext.put("surname", surname);
        logger.info("Manager created");
        ThreadContext.clearAll();
    }
}
