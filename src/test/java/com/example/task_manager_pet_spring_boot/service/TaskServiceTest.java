//package com.example.task_manager_pet_spring_boot.service;
//
//import com.example.task_manager_pet_spring_boot.entity.Task;
//import com.example.task_manager_pet_spring_boot.exception.EntityNotFoundException;
//import com.example.task_manager_pet_spring_boot.repository.TaskRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class TaskServiceTest {
//
//    @Mock
//    private TaskRepository taskRepository;
//
//    @InjectMocks
//    private TaskService taskService;
//
//    @Test
//    void findById_shouldReturnTask_whenTaskExists() {
//        // Arrange
//        UUID taskId = UUID.randomUUID();
//        Task expectedTask = new Task();
//        expectedTask.setId(taskId);
//        expectedTask.setTitle("Test Task");
//
//        when(taskRepository.findById(taskId)).thenReturn(Optional.of(expectedTask));
//
//        // Act
//        Task actualTask = taskService.findById(taskId);
//
//        // Assert
//        assertNotNull(actualTask);
//        assertEquals(taskId, actualTask.getId());
//        assertEquals("Test Task", actualTask.getTitle());
//        verify(taskRepository, times(1)).findById(taskId);
//    }
//
//    @Test
//    void findById_shouldThrowException_whenTaskNotFound() {
//        // Arrange
//        UUID nonExistentId = UUID.randomUUID();
//        when(taskRepository.findById(nonExistentId)).thenReturn(Optional.empty());
//
//        // Act & Assert
//        EntityNotFoundException exception = assertThrows(
//                EntityNotFoundException.class,
//                () -> taskService.findById(nonExistentId)
//        );
//
//        assertTrue(exception.getMessage().contains(nonExistentId.toString()));
//        verify(taskRepository, times(1)).findById(nonExistentId);
//    }
//}