package com.resellerapp.model.entity;

import com.resellerapp.model.enums.ConditionNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "conditions")
public class ConditionEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "condition_name", nullable = false, unique = true)
    private ConditionNameEnum conditionName;

    @Column(name = "description", nullable = false)
    private String description;

    public ConditionEntity() {
    }

    public ConditionNameEnum getConditionName() {
        return conditionName;
    }

    public void setConditionName(ConditionNameEnum conditionName) {
        this.conditionName = conditionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
