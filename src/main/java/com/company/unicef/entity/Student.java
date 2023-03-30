package com.company.unicef.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "STUDENT")
@Entity
public class Student {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Column(name = "BIRTH_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date birthDate;

    @Column(name = "STUDYING_CLASS", nullable = false)
    @NotNull
    private Integer studyingClass;

    @Column(name = "GENDER", nullable = false)
    @NotNull
    private Integer gender;

    @Column(name = "SPECIAL_NEEDS", nullable = false)
    @NotNull
    private Integer specialNeeds;

    @Column(name = "CONTACTS")
    private String contacts;

    public SpecialNeedsField getSpecialNeeds() {
        return specialNeeds == null ? null : SpecialNeedsField.fromId(specialNeeds);
    }

    public void setSpecialNeeds(SpecialNeedsField specialNeeds) {
        this.specialNeeds = specialNeeds == null ? null : specialNeeds.getId();
    }

    public GenderField getGender() {
        return gender == null ? null : GenderField.fromId(gender);
    }

    public void setGender(GenderField gender) {
        this.gender = gender == null ? null : gender.getId();
    }

    public StudyingClassField getStudyingClass() {
        return studyingClass == null ? null : StudyingClassField.fromId(studyingClass);
    }

    public void setStudyingClass(StudyingClassField studyingClass) {
        this.studyingClass = studyingClass == null ? null : studyingClass.getId();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}