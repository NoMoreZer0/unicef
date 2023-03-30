package com.company.unicef.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "PARENTS")
@Entity
public class Parents {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "FIO", nullable = false)
    @NotNull
    private String fio;

    @Column(name = "BIRTH_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date birthDate;

    @Column(name = "FULL_AGE", nullable = false)
    @NotNull
    private Integer fullAge;

    @Column(name = "IS_RELATIVE_PARENT")
    private Boolean isRelativeParent = false;

    @Column(name = "FAMILY_STATUS_FIELD", nullable = false)
    @NotNull
    private Integer familyStatusField;

    @Column(name = "CONTACTS")
    private String contacts;

    public FamilyStatusFielld getFamilyStatusField() {
        return familyStatusField == null ? null : FamilyStatusFielld.fromId(familyStatusField);
    }

    public void setFamilyStatusField(FamilyStatusFielld familyStatusField) {
        this.familyStatusField = familyStatusField == null ? null : familyStatusField.getId();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Boolean getIsRelativeParent() {
        return isRelativeParent;
    }

    public void setIsRelativeParent(Boolean isRelativeParent) {
        this.isRelativeParent = isRelativeParent;
    }

    public Integer getFullAge() {
        return fullAge;
    }

    public void setFullAge(Integer fullAge) {
        this.fullAge = fullAge;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}