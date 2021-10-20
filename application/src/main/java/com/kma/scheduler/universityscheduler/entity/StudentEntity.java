package com.kma.scheduler.universityscheduler.entity;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="student")
public class StudentEntity extends UserEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id")
    private final Course course;

    private static final Logger logger = LogManager.getLogger(StudentEntity.class);

    public StudentEntity(UUID id, String name, String surname, Course course) {
        super(id, name, surname);
        this.course = course;

        ThreadContext.put("name", name);
        ThreadContext.put("surname", surname);
        logger.info("Student created");
        ThreadContext.clearAll();
    }
}
