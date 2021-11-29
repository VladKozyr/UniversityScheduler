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
//    private String surname;
//    private String name;
    private String cathedra;
    private static final Logger logger = LogManager.getLogger(LectorEntity.class);

    @Builder
    public LectorEntity(Long id, String name, String surname, String cathedra) {
        super(id, name, surname);
//        this.surname = surname1;
//        this.name = name1;
        this.cathedra = cathedra;

//        ThreadContext.put("name", this.name);
//        ThreadContext.put("surname", this.surname);
        logger.info("Lector created");
        ThreadContext.clearAll();
    }
}
