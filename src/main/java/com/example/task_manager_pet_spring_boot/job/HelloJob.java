package com.example.task_manager_pet_spring_boot.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HelloJob {
    @Value("${hello.name}")
    private String name;
    @Autowired
    private HelloService helloService;

    @Scheduled(cron = "${job.hello}")
    public void hello() {
        helloService.hello();
    }
}
