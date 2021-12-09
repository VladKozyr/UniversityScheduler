package com.kma.scheduler.universityscheduler.repository;

import com.kma.scheduler.universityscheduler.entity.slot.SlotEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends CrudRepository<SlotEntity, Long> {
    @Query(value = "SELECT * FROM slot inner join course on slot.course_id=course.id where faculty = ?1", nativeQuery = true)
    Iterable<SlotEntity> getSlotByFaculty(String faculty);

    @Query(value = "SELECT * FROM slot where lector_id = ?1", nativeQuery = true)
    Iterable<SlotEntity> getSlotByLectorId(Long id);

    @Query(value = "SELECT * FROM slot where course_id = ?1", nativeQuery = true)
    Iterable<SlotEntity> getSlotByCourseId(Long id);
}
