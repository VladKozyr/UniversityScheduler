package com.kma.scheduler.universityscheduler.Entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "lectors")
@AllArgsConstructor
@ToString
public class LectorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String surname;
    private String name;
    private String cathedra;

}
