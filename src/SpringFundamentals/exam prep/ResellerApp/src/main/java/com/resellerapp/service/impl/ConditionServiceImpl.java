package com.resellerapp.service.impl;

import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.enums.ConditionNameEnum;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.service.ConditionService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConditionServiceImpl implements ConditionService {

    private final ConditionRepository conditionRepository;

    public ConditionServiceImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void initConditions() {

        if (conditionRepository.count() > 0) {
            return;
        }

        Arrays.stream(ConditionNameEnum.values())
                .forEach(conditionNameEnum -> {
                    ConditionEntity condition = new ConditionEntity();
                    condition.setConditionName(conditionNameEnum);

                    switch (conditionNameEnum) {
                        case EXCELLENT:
                            condition.setDescription("In perfect condition");
                            break;
                        case GOOD:
                            condition.setDescription("Some signs of wear and tear or minor defects");
                            break;
                        case ACCEPTABLE:
                            condition.setDescription("The item is fairly worn but continues to function properly");
                            break;
                    }
                    conditionRepository.save(condition);
                });
    }
}
