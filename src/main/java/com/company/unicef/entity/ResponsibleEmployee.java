package com.company.unicef.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "RESPONSIBLE_EMPLOYEE", indexes = {
        @Index(name = "IDX_RESPONSIBLE_EMPLOYEE_OPEN_CASE", columnList = "OPEN_CASE_ID")
})
@Entity
public class ResponsibleEmployee {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private Long id;

    @JmixGeneratedValue
    @Column(name = "UUID")
    private UUID uuid;

    @Column(name = "INVOLVEMENT")
    private String involvement;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "EMPLOYEE_ID")
    @Composition
    @OneToOne(fetch = FetchType.LAZY)
    private User employee;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OPEN_CASE_ID")
    private OpenCase openCase;

    public OpenCase getOpenCase() {
        return openCase;
    }

    public void setOpenCase(OpenCase openCase) {
        this.openCase = openCase;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public String getInvolvement() {
        return involvement;
    }

    public void setInvolvement(String involvement) {
        this.involvement = involvement;
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