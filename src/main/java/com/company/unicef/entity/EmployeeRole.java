package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum EmployeeRole implements EnumClass<String> {

    ПСИХОЛОГ("психолог"),
    КУРАТОР("куратор"),
    КЛАССНЫЙ_РУКОВОДИТЕЛЬ("классный руководитель"),
    ЗАМЕСТИТЕЛЬ_ДИРЕКТОРА("заместитель директора"),
    ДИРЕКТОР("директор"),
    ВРАЧ_ПЕДИАТР("врач-педиатр"),
    ЗАВЕДУЮЩАЯ_ОБЩЕЖИТИЕМ("заведующая общежитием"),
    АДМИНИСТРАТОР("ADMIN"),
    ВОСПИТАТЕЛЬ("воспитатель"),
    СОЦИАЛЬНЫЙ_ПЕДАГОГ("социальный педагог"),
    ШКОЛЬНЫЙ_ИНСПЕКТОР("школьный инспектор"),
    УЧИТЕЛЬ("учитель");

    private String id;

    EmployeeRole(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static EmployeeRole fromId(String id) {
        for (EmployeeRole at : EmployeeRole.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}