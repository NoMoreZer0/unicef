package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum FamilyStatusFielld implements EnumClass<String> {

    OFFICIALLY_MARRIED("Oфиц зарегистрированы в браке"),
    WIDOWED("Развод/Смерть одного из родителей/родитель-одиночка"),
    UNNOFICIALLY_TOGETHER("Совместное проживание без регистраций брака"),
    NEW_FAMILY_FAR_FROM_CHILDREN("Проживает в другой семье отдельно от ребенка");

    private String id;

    FamilyStatusFielld(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static FamilyStatusFielld fromId(String id) {
        for (FamilyStatusFielld at : FamilyStatusFielld.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}