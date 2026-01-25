package com.example.task_manager_pet_spring_boot.repository;

import com.example.task_manager_pet_spring_boot.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

}
