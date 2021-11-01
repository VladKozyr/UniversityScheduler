package com.kma.scheduler.universityscheduler.repository;

import com.kma.scheduler.universityscheduler.entity.ManagerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository  extends CrudRepository<ManagerEntity, Long> {
}
