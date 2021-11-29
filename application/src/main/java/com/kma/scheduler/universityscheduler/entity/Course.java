package com.kma.scheduler.universityscheduler.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor()
@ToString
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
@Table(name = "course", uniqueConstraints = {@UniqueConstraint(columnNames =
        {"year", "faculty"})})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int year;
    private String faculty;
}
