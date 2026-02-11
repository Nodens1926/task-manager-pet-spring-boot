package com.example.task_manager_pet_spring_boot.controller;

import com.example.task_manager_pet_spring_boot.dto.TaskDtoRq;
import com.example.task_manager_pet_spring_boot.dto.TaskDtoRs;
import com.example.task_manager_pet_spring_boot.entity.Task;
import com.example.task_manager_pet_spring_boot.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping()
    public ResponseEntity<Page<TaskDtoRs>> findAll(@PageableDefault(page = 0, size = 20, sort = "title", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(taskService.findAll(pageable));
    }

    @PostMapping()
    public ResponseEntity<TaskDtoRs> save(@RequestBody @Valid TaskDtoRq taskDtoRq) {
        return ResponseEntity.ok(taskService.save(taskDtoRq));
    }

    // -------------------------

    @PutMapping("/{id}")
    public ResponseEntity<TaskDtoRs> update(@RequestBody @Valid TaskDtoRq taskDtoRq, @PathVariable UUID id) {
        return ResponseEntity.ok(taskService.update(taskDtoRq, id));
    }

    //НУЖНО ИСПОЛЬЗОВАТЬ void или ResponseEntity<?>
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
