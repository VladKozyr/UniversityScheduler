package com.kma.scheduler.universityscheduler.repository;

import com.kma.scheduler.universityscheduler.Entity.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer>{

}
