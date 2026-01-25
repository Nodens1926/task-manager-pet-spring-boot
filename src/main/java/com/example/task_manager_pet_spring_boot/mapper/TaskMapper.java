package com.example.task_manager_pet_spring_boot.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.example.task_manager_pet_spring_boot.dto.TaskDtoRq;
import com.example.task_manager_pet_spring_boot.dto.TaskDtoRs;
import com.example.task_manager_pet_spring_boot.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="spring")
public abstract class TaskMapper {
    @Mapping(target="taskId", source="id")
    public abstract TaskDtoRs map(Task model);

    public abstract Task rqToModel(TaskDtoRq taskDtoRq);
}
