package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum CaseStatus implements EnumClass<String> {

    OPEN("A"),
    CLOSED("B");

    private String id;

    CaseStatus(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CaseStatus fromId(String id) {
        for (CaseStatus at : CaseStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}