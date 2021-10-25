package com.kma.scheduler.universityscheduler.service.schedule;

import com.kma.scheduler.universityscheduler.entity.Course;
import com.kma.scheduler.universityscheduler.entity.slot.SlotEntity;
import com.kma.scheduler.universityscheduler.model.Lector;
import com.kma.scheduler.universityscheduler.model.Slot;
import com.kma.scheduler.universityscheduler.repository.SlotRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ScheduleService {

    private final SlotRepository repository;

    public ScheduleService(SlotRepository repository) {
        this.repository = repository;
    }

    public Slot[] getCourseSchedule(Course course) {
        return null;
    }

    public Slot[] getLectorSchedule(Lector lector) {
        return null;
    }

    public Slot updateSlot(Slot slot) {
        return slot;
    }

    public void updateSlot(UUID slotUUID, UUID lectorUUID, UUID courseUUID) {
        Optional<SlotEntity> slotEntityOptional = repository.findById(slotUUID);
        if (slotEntityOptional.isPresent()) {
            SlotEntity slot = slotEntityOptional.get();
            //TODO update with mapping
        }
    }
}
