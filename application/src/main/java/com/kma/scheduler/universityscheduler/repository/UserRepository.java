package com.kma.scheduler.universityscheduler.repository;

import com.kma.scheduler.universityscheduler.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserDetails> findUserEntityByLogin(String login);
}
