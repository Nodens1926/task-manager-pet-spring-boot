package com.example.task_manager_pet_spring_boot.service;

import com.example.task_manager_pet_spring_boot.dto.TaskDtoRq;
import com.example.task_manager_pet_spring_boot.dto.TaskDtoRs;
import com.example.task_manager_pet_spring_boot.entity.Task;
import com.example.task_manager_pet_spring_boot.exception.EntityNotFoundException;
import com.example.task_manager_pet_spring_boot.mapper.TaskMapper;
import com.example.task_manager_pet_spring_boot.repository.TaskRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Transactional(readOnly = true)
    public TaskDtoRs findById(UUID id) {
        return  taskMapper.map(taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task with id " + id + " not found")));
    }

    @Transactional(readOnly = true)
    public Page<TaskDtoRs> findAll(Pageable pageable) {
        return taskRepository.findAll(pageable).map(taskMapper::map);
    }

    @Transactional()
    public TaskDtoRs save(TaskDtoRq dto) {
        Task task = taskMapper.rqToModel(dto);
        return  taskMapper.map(taskRepository.save(task));
    }

    // -------------------------

    @Transactional()
    public void delete(UUID id) {
        taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task with id " + id + " not found"));

        taskRepository.deleteById(id);
    }

    @Transactional()
    public TaskDtoRs update(TaskDtoRq dto, UUID id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task with id " + id + " not found"));

        return taskMapper.map(taskRepository.save(taskMapper.rqToModel(dto, task)));
    }
}
