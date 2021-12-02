package com.kma.scheduler.universityscheduler.controller.mapping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SlotEditMapping {

    Long courseId;
    Long lectorId;
}