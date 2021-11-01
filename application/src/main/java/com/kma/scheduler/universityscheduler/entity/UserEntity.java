package com.kma.scheduler.universityscheduler.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public abstract class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Blank name...")
    private String name;
    @NotBlank(message = "Blank surname...")
    private String surname;
}