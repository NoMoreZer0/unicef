package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum GradeSecondTerm implements EnumClass<String> {

    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4");

    private final String id;

    GradeSecondTerm(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static GradeSecondTerm fromId(String id) {
        for (GradeSecondTerm at : GradeSecondTerm.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}