package com.example.task_manager_pet_spring_boot.exception;

import com.example.task_manager_pet_spring_boot.dto.ErrorDto;
import com.example.task_manager_pet_spring_boot.dto.TaskDtoRs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException e){
        ErrorDto errorDto = ErrorDto.builder()
                .code(404).message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }
}
