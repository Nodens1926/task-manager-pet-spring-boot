package com.example.task_manager_pet_spring_boot.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TaskStatus {
    TODO("В ОЖИДАНИИ"),
    IN_PROGRESS("В РАБОТЕ"),
    DONE("ВЫПОЛНЕНО"),
    CANCELED("ОТМЕНЕН");
    private final String description;
}
