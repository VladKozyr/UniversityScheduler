package com.kma.scheduler.universityscheduler.Entity;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String surname;
    private String name;
    private String role;

    public UserEntity(String name, String surname, String role){
        this.surname = surname;
        this.name = name;
        this.role = role;
    }
}
