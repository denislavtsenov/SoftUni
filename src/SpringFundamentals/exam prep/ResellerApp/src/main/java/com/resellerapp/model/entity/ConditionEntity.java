package com.resellerapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "conditions")
public class ConditionEntity extends BaseEntity {

    @Column(name = "condition_name", nullable = false, unique = true)
    private String conditionName;

    @Column(name = "description", nullable = false)
    private String description;

    public ConditionEntity() {
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
