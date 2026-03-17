package com.example.task_manager_pet_spring_boot.service;

import com.example.task_manager_pet_spring_boot.dto.TaskDtoRs;
import com.example.task_manager_pet_spring_boot.entity.Task;
import com.example.task_manager_pet_spring_boot.exception.EntityNotFoundException;
import com.example.task_manager_pet_spring_boot.mapper.TaskMapper;
import com.example.task_manager_pet_spring_boot.repository.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;
    @Mock
    private TaskMapper taskMapper;
    @InjectMocks
    private TaskService taskService;

    @Test
    @DisplayName("Проверка существующего теста по id")
    void findByIdTestWhenTaskExists() {
        // when
        UUID taskId = UUID.randomUUID();
        Task task = new Task();
        task.setId(taskId);
        TaskDtoRs taskDtoRs = new TaskDtoRs();
        taskDtoRs.setTaskId(taskId);
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));
        when(taskMapper.map(task)).thenReturn(taskDtoRs);

        // do
        TaskDtoRs result = taskService.findById(taskId);

        // then
        assertNotNull(result);
        assertEquals(taskId, taskDtoRs.getTaskId());
        verify(taskRepository).findById(taskId);
        verifyNoMoreInteractions(taskRepository);
    }

    @Test
    @DisplayName("Проверка несуществующего теста по id")
    void findByIdTestWhenTaskNotExists() {
        // when
        UUID taskId = UUID.randomUUID();
        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());

        // do/then
        assertThrows(EntityNotFoundException.class, () -> taskService.findById(taskId));
        verify(taskRepository).findById(taskId);
        verifyNoInteractions(taskMapper);
    }
}