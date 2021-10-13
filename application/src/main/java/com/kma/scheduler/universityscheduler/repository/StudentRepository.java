package com.kma.scheduler.universityscheduler.repository;

import com.kma.scheduler.universityscheduler.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, UUID>{

}
