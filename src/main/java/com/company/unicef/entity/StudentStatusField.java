package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum StudentStatusField implements EnumClass<String> {

    RED("A"),
    GREEN("B"),
    GRAY("C"),
    YELLOW("D");

    private String id;

    StudentStatusField(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static StudentStatusField fromId(String id) {
        for (StudentStatusField at : StudentStatusField.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}