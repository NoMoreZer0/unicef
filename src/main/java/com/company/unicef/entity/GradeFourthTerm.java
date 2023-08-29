package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum GradeFourthTerm implements EnumClass<String> {

    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4");

    private final String id;

    GradeFourthTerm(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static GradeFourthTerm fromId(String id) {
        for (GradeFourthTerm at : GradeFourthTerm.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}