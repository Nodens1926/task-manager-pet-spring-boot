package com.example.task_manager_pet_spring_boot.dto;

import com.example.task_manager_pet_spring_boot.entity.Priority;
import com.example.task_manager_pet_spring_boot.entity.TaskStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class TaskDtoRs {
    private UUID taskId;

    private String title;

    private String description;

    private TaskStatus status;

    private Priority priority;

    private LocalDateTime dueDate;

    private LocalDateTime createdAt;
}
