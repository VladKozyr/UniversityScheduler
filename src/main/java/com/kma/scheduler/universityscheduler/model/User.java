package com.kma.scheduler.universityscheduler.model;

public abstract class User{
    private final String name;
    private final String surname;
    User(String name, String surname){
        this.name=name;
        this.surname=surname;
    }
}
