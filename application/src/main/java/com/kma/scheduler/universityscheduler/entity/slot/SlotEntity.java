package com.kma.scheduler.universityscheduler.entity.slot;

import com.kma.scheduler.universityscheduler.entity.LectorEntity;
import com.kma.scheduler.universityscheduler.entity.Course;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "slot",uniqueConstraints = { @UniqueConstraint(columnNames =
        { "time", "day","course_id" }) })
@AllArgsConstructor
public class SlotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID id;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private final Course course;

    @Enumerated(EnumType.STRING)
    @Column(name="time")
    private final SlotTime time;

    @Enumerated(EnumType.STRING)
    @Column(name="day")
    private final SlotDay day;

    @OneToOne
    private final LectorEntity lector;
    private final String room;


}
