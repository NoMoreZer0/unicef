package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum GenderField implements EnumClass<Integer> {

    MALE(10),
    FEMALE(20);

    private Integer id;

    GenderField(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static GenderField fromId(Integer id) {
        for (GenderField at : GenderField.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}