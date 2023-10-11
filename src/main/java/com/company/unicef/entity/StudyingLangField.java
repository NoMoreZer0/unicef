package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum StudyingLangField implements EnumClass<String> {

    KAZAKH("A"),
    RUSSIAN("B"),
    ENGLISH("C");

    private String id;

    StudyingLangField(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static StudyingLangField fromId(String id) {
        for (StudyingLangField at : StudyingLangField.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}