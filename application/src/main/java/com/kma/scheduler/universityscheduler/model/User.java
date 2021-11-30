package com.kma.scheduler.universityscheduler.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public abstract class User{
    private final Long id;
    private final String name;
    private final String login;
}
