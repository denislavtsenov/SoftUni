package com.plannerapp.repo;

import com.plannerapp.model.entity.TaskEntity;
import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.model.service.TaskServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findByAssignee(UserEntity user);

    @Query("SELECT t FROM TaskEntity t WHERE t.assignee.id IS null")
    List<TaskEntity> getAllAvailable();
}
