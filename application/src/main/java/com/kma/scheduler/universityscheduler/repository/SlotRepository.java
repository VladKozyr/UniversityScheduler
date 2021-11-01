package com.kma.scheduler.universityscheduler.repository;

import com.kma.scheduler.universityscheduler.entity.slot.SlotEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends CrudRepository<SlotEntity, Long> {
}
