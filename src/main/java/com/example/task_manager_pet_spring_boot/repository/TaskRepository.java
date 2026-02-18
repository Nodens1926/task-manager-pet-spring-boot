package com.example.task_manager_pet_spring_boot.repository;

import com.example.task_manager_pet_spring_boot.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    @Override
//    @Query("""
//        SELECT DISTINCT t
//        FROM Task t
//        LEFT JOIN FETCH t.tags
//    """)
    @EntityGraph(attributePaths = "tags")
    Page<Task> findAll(Pageable pageable);
}
