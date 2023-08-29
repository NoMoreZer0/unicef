package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum EducationalInstitution implements EnumClass<String> {

    SCHOOL("A"),
    SCHOOLLYCEUM("B"),
    SCHOOLHYMNASIUM("C"),
    SPECIALSCHOOL("D");

    private String id;

    EducationalInstitution(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static EducationalInstitution fromId(String id) {
        for (EducationalInstitution at : EducationalInstitution.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}