package com.kma.scheduler.universityscheduler.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@ToString
@AllArgsConstructor
public abstract class User{
    private final UUID id;
    private final String name;
    private final String surname;
}
