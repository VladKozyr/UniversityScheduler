package com.kma.scheduler.universityscheduler.controller.mapping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class LectorAddMapping {

    String lectorName;
    String login;
    String password;
    String cathedra;
}
