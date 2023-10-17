package com.plannerapp.service.impl;

import com.plannerapp.model.entity.PriorityEntity;
import com.plannerapp.model.enums.PriorityNameEnum;
import com.plannerapp.service.PriorityService;
import com.plannerapp.repo.PriorityRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PriorityServiceImpl implements PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityServiceImpl(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void initPriorities() {

        if (priorityRepository.count() > 0) {
            return;
        }

        Arrays.stream(PriorityNameEnum.values())
                .forEach(priorityNameEnum -> {
                    PriorityEntity priority = new PriorityEntity();
                    priority.setPriorityName(priorityNameEnum);

                    switch (priorityNameEnum) {
                        case URGENT:
                            priority.setDescription("An urgent problem that blocks the system use until the issue is resolved.");
                            break;
                        case IMPORTANT:
                            priority.setDescription("A core functionality that your product is explicitly supposed to perform is compromised.");
                            break;
                        case LOW:
                            priority.setDescription("Should be fixed if time permits but can be postponed.");
                    }

                    priorityRepository.save(priority);
                });
    }
}
