package com.kma.scheduler.universityscheduler.controller.requests;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    String name;
    String surname;
    String password;
}
