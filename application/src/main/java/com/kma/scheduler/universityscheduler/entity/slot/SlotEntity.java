package com.kma.scheduler.universityscheduler.entity.slot;

import com.kma.scheduler.universityscheduler.entity.LectorEntity;
import com.kma.scheduler.universityscheduler.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "slot", uniqueConstraints = {@UniqueConstraint(columnNames =
        {"time", "day", "course_id"})})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SlotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Enumerated(EnumType.STRING)
    @Column(name = "time")
    private SlotTime time;

    @Enumerated(EnumType.STRING)
    @Column(name = "day")
    private SlotDay day;

    @OneToOne
    private LectorEntity lector;
    private String room;
}
