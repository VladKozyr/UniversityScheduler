package com.kma.scheduler.universityscheduler.entity;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor()
@Table(name="course",uniqueConstraints = { @UniqueConstraint(columnNames =
        { "year","faculty" }) })
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID id;
    private final int year;
    private final String faculty;
}
