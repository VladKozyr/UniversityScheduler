package com.kma.scheduler.universityscheduler.repository;

import com.kma.scheduler.universityscheduler.Entity.LectorEntity;
import com.kma.scheduler.universityscheduler.Entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepository extends CrudRepository<LectorEntity, Integer> {
}
