package com.kma.scheduler.universityscheduler.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
@AllArgsConstructor
public abstract class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID id;
    private final String name;
    private final String surname;
}