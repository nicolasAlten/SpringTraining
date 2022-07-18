package com.spring.springTraining.Service;

import com.spring.springTraining.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAll();
    UserEntity findById(int id);
    UserEntity findByIdAndName(int id, String name);
}
