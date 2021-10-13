package com.kma.scheduler.universityscheduler.entity;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="student")
public class StudentEntity extends UserEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id")
    private final Course course;

    public StudentEntity(UUID id, String name, String surname, Course course) {
        super(id, name, surname);
        this.course = course;
    }
}
