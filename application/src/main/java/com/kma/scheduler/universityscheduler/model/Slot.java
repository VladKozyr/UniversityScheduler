package com.kma.scheduler.universityscheduler.model;

import lombok.Getter;
import lombok.Setter;

public class Slot {
    @Getter
    private final String time;
    @Getter @Setter
    private Lector teacher;
    @Getter @Setter
    private String room;

    public Slot(String time, Lector teacher, String room){
        this.time = time;
        this.teacher = teacher;
        this.room = room;
    }
}
