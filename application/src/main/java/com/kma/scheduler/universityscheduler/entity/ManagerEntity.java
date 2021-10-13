package com.kma.scheduler.universityscheduler.entity;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="manager")
public class ManagerEntity extends UserEntity {
    public ManagerEntity(UUID id, String name, String surname) {
        super(id, name, surname);
    }
}
