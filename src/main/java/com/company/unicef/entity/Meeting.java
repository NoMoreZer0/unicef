package com.company.unicef.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "MEETING", indexes = {
        @Index(name = "IDX_MEETING_FIRST_FORM", columnList = "FIRST_FORM_ID")
})
@Entity
public class Meeting {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private Long id;

    @Column(name = "DATE_")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "FIO")
    private String fio;

    @Column(name = "MEETING_ORGANIZER")
    private String meetingOrganizer;

    @Column(name = "ORGANIZATION_NAME")
    private String organizationName;

    @Column(name = "RELATIVE_")
    private String relative;

    @Column(name = "CONTACT")
    private String contact;

    @JmixGeneratedValue
    @Column(name = "UUID")
    private UUID uuid;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "FIRST_FORM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private FirstForm firstForm;

    public String getMeetingOrganizer() {
        return meetingOrganizer;
    }

    public void setMeetingOrganizer(String meetingOrganizer) {
        this.meetingOrganizer = meetingOrganizer;
    }

    public FirstForm getFirstForm() {
        return firstForm;
    }

    public void setFirstForm(FirstForm firstForm) {
        this.firstForm = firstForm;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRelative() {
        return relative;
    }

    public void setRelative(String relative) {
        this.relative = relative;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}