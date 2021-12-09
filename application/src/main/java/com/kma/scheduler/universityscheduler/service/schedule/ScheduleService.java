package com.kma.scheduler.universityscheduler.service.schedule;

import com.kma.scheduler.universityscheduler.entity.Course;
import com.kma.scheduler.universityscheduler.entity.LectorEntity;
import com.kma.scheduler.universityscheduler.entity.slot.SlotEntity;
import com.kma.scheduler.universityscheduler.model.Lector;
import com.kma.scheduler.universityscheduler.model.Slot;
import com.kma.scheduler.universityscheduler.repository.CourseRepository;
import com.kma.scheduler.universityscheduler.repository.LectorRepository;
import com.kma.scheduler.universityscheduler.repository.SlotRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    private final SlotRepository slotRepository;
    private final LectorRepository lectorRepository;
    private final CourseRepository courseRepository;

    public ScheduleService(SlotRepository slotRepository, LectorRepository lectorRepository, CourseRepository courseRepository) {
        this.slotRepository = slotRepository;
        this.lectorRepository = lectorRepository;
        this.courseRepository = courseRepository;
    }

    public List<SlotEntity> getAllSlots() {
        List<SlotEntity> slots = new ArrayList<>();
        slotRepository.findAll().iterator().forEachRemaining(slots::add);
        return slots;
    }

    public SlotEntity getById(Long id) {
        return slotRepository.findById(id).get();
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

    public List<SlotEntity> getSlotByFaculty(String faculty){
        List<SlotEntity> slots = new ArrayList<SlotEntity>();
        slotRepository.getSlotByFaculty(faculty).iterator().forEachRemaining(slots::add);
        return slots;
    }

    public List<SlotEntity> getSlotByLectorId(Long id){
        List<SlotEntity> slots = new ArrayList<SlotEntity>();
        slotRepository.getSlotByLectorId(id).iterator().forEachRemaining(slots::add);
        return slots;
    }

    public List<SlotEntity> getSlotByCourseId(Long id){
        List<SlotEntity> slots = new ArrayList<SlotEntity>();
        slotRepository.getSlotByCourseId(id).iterator().forEachRemaining(slots::add);
        return slots;
    }

    public void updateSlot(Long slotId, Long lectorId, Long courseId) {
        Optional<SlotEntity> slotEntityOptional = slotRepository.findById(slotId);

        if (slotEntityOptional.isPresent()) {
            SlotEntity slot = slotEntityOptional.get();


            Optional<LectorEntity> lectorEntityOptional = lectorRepository.findById(lectorId);
            lectorEntityOptional.ifPresent(slot::setLector);


            Optional<Course> courseOptional = courseRepository.findById(courseId);
            courseOptional.ifPresent(slot::setCourse);

            slotRepository.save(slot);
        }
    }
}
