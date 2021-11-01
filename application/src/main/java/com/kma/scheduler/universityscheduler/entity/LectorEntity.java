package com.kma.scheduler.universityscheduler.entity;

import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import javax.persistence.*;

@Entity
@Table(name = "lector")
@ToString
public class LectorEntity extends UserEntity {
    private final String surname;
    private final String name;
    private final String cathedra;
    private static final Logger logger = LogManager.getLogger(LectorEntity.class);

    public LectorEntity(Long id, String name, String surname, String surname1, String name1, String cathedra) {
        super(id, name, surname);
        this.surname = surname1;
        this.name = name1;
        this.cathedra = cathedra;

        ThreadContext.put("name", this.name);
        ThreadContext.put("surname", this.surname);
        logger.info("Lector created");
        ThreadContext.clearAll();
    }
}
