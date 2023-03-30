package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum SpecialNeedsField implements EnumClass<Integer> {

    NO(10),
    NO_INFORMATION(20),
    YES(30);

    private Integer id;

    SpecialNeedsField(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static SpecialNeedsField fromId(Integer id) {
        for (SpecialNeedsField at : SpecialNeedsField.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}