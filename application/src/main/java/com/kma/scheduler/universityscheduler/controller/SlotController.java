package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.exception.student.SlotBadUpdateException;
import com.kma.scheduler.universityscheduler.exception.student.StudentNotFoundException;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("timeslot")
public class SlotController {
    private final ScheduleService scheduleService;
    private Logger logger = LogManager.getLogger();

    public SlotController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    @PutMapping("/update")
    public String updateTimeslot(@NotNull @RequestParam Long slotId, Long lectorId, Long courseId) {
        try {
            scheduleService.updateSlot(slotId, lectorId, courseId);
        } catch (Exception e) {
            throw new SlotBadUpdateException();
        }
        return "Updated";
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Bad Update Parameters")
    @ExceptionHandler(SlotBadUpdateException.class)
    public void notFound() {
        logger.error("Slot bad update");
    }

}
