package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum HealthChronicalOption implements EnumClass<String> {

    ПСИХИЧЕСКОЕ_НАРУШЕНИЕ("психическое нарушение"),
    ФИЗИЧЕСКОЕ_НАРУШЕНИЕ("физическое нарушение"),
    МНОЖЕСТВЕННЫЕ_НАРУШЕНИЯ("множественные нарушения"),
    СЕНСОРНЫЕ_НАРУШЕНИЯ("сенсорные нарушения"),
    ДРУГОЕ("другое");

    private final String id;

    HealthChronicalOption(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static HealthChronicalOption fromId(String id) {
        for (HealthChronicalOption at : HealthChronicalOption.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}