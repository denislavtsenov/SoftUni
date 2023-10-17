package com.plannerapp.init;

import com.plannerapp.model.service.PriorityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final PriorityService priorityService;

    public DatabaseInit(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @Override
    public void run(String... args) throws Exception {

        priorityService.initPriorities();
    }
}
