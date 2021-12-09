package com.kma.scheduler.universityscheduler.controller.mapping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudentAddMapping {

    String studentName;
    String login;
    String password;
    Long courseId;
}
