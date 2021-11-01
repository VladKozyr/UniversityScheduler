package com.kma.scheduler.universityscheduler.repository;

import com.kma.scheduler.universityscheduler.entity.LectorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepository extends CrudRepository<LectorEntity, Long> {
}
