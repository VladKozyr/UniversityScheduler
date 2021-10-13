package com.kma.scheduler.universityscheduler.repository;

import com.kma.scheduler.universityscheduler.entity.ManagerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ManagerRepository  extends CrudRepository<ManagerEntity, UUID> {
}
