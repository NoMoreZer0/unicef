package com.company.unicef.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "REPRESENTATIVES", indexes = {
        @Index(name = "IDX_REPRESENTATIVES_OPEN_CASE", columnList = "OPEN_CASE_ID")
})
@Entity
public class Representatives {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private Long id;

    @JmixGeneratedValue
    @Column(name = "UUID")
    private UUID uuid;

    @Column(name = "FIO")
    private String fio;

    @Column(name = "ORGANIZATION")
    private String organization;

    @Column(name = "CONTACT_INFO")
    private String contactInfo;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "OPEN_CASE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private OpenCase openCase;

    public OpenCase getOpenCase() {
        return openCase;
    }

    public void setOpenCase(OpenCase openCase) {
        this.openCase = openCase;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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