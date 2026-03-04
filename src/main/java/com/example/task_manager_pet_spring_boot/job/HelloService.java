package com.example.task_manager_pet_spring_boot.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class HelloService {
    @Async
    public void hello() {
        System.out.println("hello");
        System.out.println(Thread.currentThread());
        System.out.println("gdb");
    }
}
