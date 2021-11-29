package com.kma.scheduler.universityscheduler.entity;


import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@ToString
@Setter
@Getter
@Data
public class StudentEntity extends UserEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    private static final Logger logger = LogManager.getLogger(StudentEntity.class);

    @Builder
    public StudentEntity(Long id, String name, String surname, Course course) {
        super(id, name, surname);
        this.course = course;

        ThreadContext.put("name", name);
        ThreadContext.put("surname", surname);
        logger.info("Student created");
        ThreadContext.clearAll();
    }

}
