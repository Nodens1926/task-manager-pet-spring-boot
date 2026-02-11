package com.example.task_manager_pet_spring_boot.dto;

import com.example.task_manager_pet_spring_boot.entity.Priority;
import com.example.task_manager_pet_spring_boot.entity.TaskStatus;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class TaskDtoRq {
    @NotBlank(message="title must be not null")
    @Size(max = 255, message = "Title too long")
    private String title;
    private String description;
    @NotNull(message = "Needs Status")
    private TaskStatus status;
    @NotNull(message = "Needs Priority")
    private Priority priority;
    @JsonProperty("due_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dueDate;
}
