package com.kma.scheduler.universityscheduler.model;

import lombok.Getter;
import lombok.Setter;

abstract class Human {
    @Getter
    @Setter
    protected String name;
    @Getter @Setter
    protected String surname;
    protected final int id;
    private static int availableId = 0;

    public Human(String name, String surname){
        this.name = name;
        this.surname = surname;
        id = availableId++;
    }
}
