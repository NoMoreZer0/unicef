package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum GenderField implements EnumClass<String> {

    MALE("Мужской"),
    FEMALE("Женский");

    private String id;

    GenderField(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static GenderField fromId(String id) {
        for (GenderField at : GenderField.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}