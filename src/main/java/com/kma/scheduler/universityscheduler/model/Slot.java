package com.kma.scheduler.universityscheduler.model;

import lombok.Getter;
import lombok.Setter;

public class Slot {
    @Getter
    private String time;
    @Getter @Setter
    private Teacher teacher;
    @Getter @Setter
    private String room;

    public Slot(String time, Teacher teacher, String room){
        this.time = time;
        this.teacher = teacher;
        this.room = room;
    }
}
