package com.kma.scheduler.universityscheduler.controller.requests;

import lombok.Getter;

@Getter
public class CreateLectorRequest extends CreateUserRequest {
    String cathedra;
    String name;
    String login;
    String password;
}
