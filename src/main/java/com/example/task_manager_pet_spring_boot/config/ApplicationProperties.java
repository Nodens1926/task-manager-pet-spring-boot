package com.example.task_manager_pet_spring_boot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class ApplicationProperties {
    private String name;
    private String version;
    private String mode;

}
