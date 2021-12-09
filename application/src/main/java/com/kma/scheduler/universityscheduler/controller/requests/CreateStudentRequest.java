package com.kma.scheduler.universityscheduler.controller.requests;

import lombok.Getter;

@Getter
public class CreateStudentRequest extends CreateUserRequest {
    Long courseId;
}
