package com.example.task_manager_pet_spring_boot.controller;

import com.example.task_manager_pet_spring_boot.config.ApplicationProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/app")
public class ApplicationPropertiesController {
    @Autowired
    private ApplicationProperties applicationProperties;

    @GetMapping
    public String getApp() {
        return applicationProperties.getName() + " returned with mode: " + applicationProperties.getMode() + " and version: " + applicationProperties.getVersion();
    }
}
