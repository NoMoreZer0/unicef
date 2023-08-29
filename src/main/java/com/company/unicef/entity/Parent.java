package com.company.unicef.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "PARENT", indexes = {
        @Index(name = "IDX_PARENT_ADDRESS", columnList = "ADDRESS_ID"),
        @Index(name = "IDX_PARENT_STUDENT", columnList = "STUDENT_ID"),
        @Index(name = "IDX_PARENT_EVENT", columnList = "EVENT_ID")
})
@Entity
public class Parent {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "FIO")
    private String fio;

    @Column(name = "FULL_AGE")
    private Integer fullAge;

    @Column(name = "FAMILY_STATUS")
    private String familyStatus;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "ADDRESS_ID")
    @Composition
    @OneToOne(fetch = FetchType.LAZY)
    private Address address;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Student student;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @JoinColumn(name = "EVENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public FamilyStatusFielld getFamilyStatus() {
        return familyStatus == null ? null : FamilyStatusFielld.fromId(familyStatus);
    }

    public void setFamilyStatus(FamilyStatusFielld familyStatus) {
        this.familyStatus = familyStatus == null ? null : familyStatus.getId();
    }

    public Integer getFullAge() {
        return fullAge;
    }

    public void setFullAge(Integer fullAge) {
        this.fullAge = fullAge;
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