package com.kma.scheduler.universityscheduler.repository;

import com.kma.scheduler.universityscheduler.entity.slot.SlotEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SlotRepository extends CrudRepository<SlotEntity, UUID> {
}
