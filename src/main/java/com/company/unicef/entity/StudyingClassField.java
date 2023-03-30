package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum StudyingClassField implements EnumClass<Integer> {

    SEVEN(10),
    EIGHT(20),
    NINE(30),
    TEN(40),
    ELEVEN(50),
    TWELVE(60);

    private Integer id;

    StudyingClassField(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static StudyingClassField fromId(Integer id) {
        for (StudyingClassField at : StudyingClassField.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}