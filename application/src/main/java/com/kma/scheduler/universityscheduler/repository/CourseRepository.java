package com.kma.scheduler.universityscheduler.repository;

import com.kma.scheduler.universityscheduler.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends CrudRepository<Course, UUID> {
}
