package com.kma.scheduler.universityscheduler.entity;

import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import javax.persistence.*;

@Entity
@Table(name = "lector")
@ToString
@NoArgsConstructor
@Setter
@Getter
@Data
public class LectorEntity extends UserEntity {
    private String cathedra;
    private static final Logger logger = LogManager.getLogger(LectorEntity.class);


    public LectorEntity(Long id, String name, String login, String password, String cathedra) {
        super(id, name, login,password,Role.LECTOR);
        this.cathedra = cathedra;

        logger.info("Lector created");
        ThreadContext.clearAll();
    }
}
