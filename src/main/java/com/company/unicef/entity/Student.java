package com.company.unicef.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@JmixEntity
@Table(name = "STUDENT")
@Entity
public class Student {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "FIO")
    private String fio;

    @Column(name = "GENDER")
    private Integer gender;

    @Column(name = "STUDYING_YEAR")
    private String studyingYear;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "STATUS")
    private String status;

    public StudentStatusField getStatus() {
        return status == null ? null : StudentStatusField.fromId(status);
    }

    public void setStatus(StudentStatusField status) {
        this.status = status == null ? null : status.getId();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStudyingYear() {
        return studyingYear;
    }

    public void setStudyingYear(String studyingYear) {
        this.studyingYear = studyingYear;
    }

    public GenderField getGender() {
        return gender == null ? null : GenderField.fromId(gender);
    }

    public void setGender(GenderField gender) {
        this.gender = gender == null ? null : gender.getId();
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