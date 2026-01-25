package com.example.task_manager_pet_spring_boot.controller;

import com.example.task_manager_pet_spring_boot.dto.TaskDtoRq;
import com.example.task_manager_pet_spring_boot.dto.TaskDtoRs;
import com.example.task_manager_pet_spring_boot.entity.Task;
import com.example.task_manager_pet_spring_boot.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
@Slf4j
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<TaskDtoRs> findById(@PathVariable UUID id) {
        TaskDtoRs task = taskService.findById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping()
    public ResponseEntity<TaskDtoRs> save(@RequestBody TaskDtoRq taskDtoRq) {
        return ResponseEntity.ok(taskService.save(taskDtoRq));
    }
}
