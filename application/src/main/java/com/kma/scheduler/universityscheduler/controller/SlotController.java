package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("timeslot")
public class SlotController {
    private final ScheduleService scheduleService;

    public SlotController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    @PutMapping("/update")
    public String updateTimeslot(@RequestParam Long slotId, Long lectorId, Long courseId) {
        scheduleService.updateSlot(slotId, lectorId, courseId);
        return "Updated";
    }
}
