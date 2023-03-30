package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum FamilyStatusFielld implements EnumClass<Integer> {

    OFFICIALLY_MARRIED(10),
    WIDOWED(20),
    UNNOFICIALLY_TOGETHER(30);

    private Integer id;

    FamilyStatusFielld(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static FamilyStatusFielld fromId(Integer id) {
        for (FamilyStatusFielld at : FamilyStatusFielld.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}