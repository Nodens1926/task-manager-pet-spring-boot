package com.example.task_manager_pet_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAsync
@SpringBootApplication
@ConfigurationPropertiesScan("com.example.task_manager_pet_spring_boot.config")
public class TaskManagerPetSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerPetSpringBootApplication.class, args);
    }

}
