package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum RiskLevel implements EnumClass<String> {

    HIGH("A"),
    MEDIUM("B"),
    LOW("C");

    private String id;

    RiskLevel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static RiskLevel fromId(String id) {
        for (RiskLevel at : RiskLevel.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}