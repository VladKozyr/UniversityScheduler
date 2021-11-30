package com.kma.scheduler.universityscheduler.controller.requests;

import com.kma.scheduler.universityscheduler.entity.Course;
import lombok.Getter;

@Getter
public class CreateStudentRequest extends CreateUserRequest {
    Long courseId;
}
