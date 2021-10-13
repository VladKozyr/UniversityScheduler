package com.kma.scheduler.universityscheduler.entity;

import com.kma.scheduler.universityscheduler.model.User;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "lector")
@ToString
public class LectorEntity extends UserEntity {
    private final String surname;
    private final String name;
    private final String cathedra;

    public LectorEntity(UUID id, String name, String surname, String surname1, String name1, String cathedra) {
        super(id, name, surname);
        this.surname = surname1;
        this.name = name1;
        this.cathedra = cathedra;
    }
}
