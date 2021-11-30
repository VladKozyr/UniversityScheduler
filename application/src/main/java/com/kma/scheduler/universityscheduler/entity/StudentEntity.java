package com.kma.scheduler.universityscheduler.entity;


import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import javax.persistence.*;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "student")
@NoArgsConstructor
@ToString
@Setter
@Getter
@Data
public class StudentEntity extends UserEntity {
    @ManyToOne()
    @JoinColumn(name = "course_id")
    private Course course;

    private static final Logger logger = LogManager.getLogger(StudentEntity.class);

    @Builder
    public StudentEntity(Long id, String name, String login, String password, Course course) {
        super(id, name, login, password, Role.STUDENT);
        this.course = course;

        ThreadContext.put("name", name);
        ThreadContext.put("login", login);
        logger.info("Student created");
        ThreadContext.clearAll();
    }

}
