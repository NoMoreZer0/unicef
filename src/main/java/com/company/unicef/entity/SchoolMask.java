package com.company.unicef.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum SchoolMask implements EnumClass<String> {

    XBN_AKTAU("A"),
    FMN_AKTOBE("B"),
    FMN_ALMATY("C"),
    XBN_ALMATY("D"),
    IB_ASTANA("E"),
    FMN_ASTANA("F"),
    MSH_ASTANA("G"),
    XBN_ATYRAU("H"),
    XBN_KARAGANDY("I"),
    FMN_KOKSHETAU("J"),
    FMN_KOSTANAY("K"),
    XBN_KYZYLORDA("L"),
    XBN_PAVLODAR("M"),
    XBN_PETROPAVLSK("N"),
    FMN_SEMEY("O"),
    FMN_TALDYKORGAN("P"),
    FMN_TARAZ("Q"),
    XBN_TURKESTAN("R"),
    FMN_URALSK("S"),
    XBN_OSKEMEN("T"),
    FMN_SHYMKENT("U"),
    XBN_SHYMKENT("V");

    private final String id;

    SchoolMask(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static SchoolMask fromId(String id) {
        for (SchoolMask at : SchoolMask.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}