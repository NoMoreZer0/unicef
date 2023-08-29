    package com.company.unicef.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "NEED_NAMES", indexes = {
        @Index(name = "IDX_NEED_NAMES_SECOND_FORM_CHECK_BOX", columnList = "SECOND_FORM_CHECK_BOX_ID")
})
@Entity
public class NeedNames {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME")
    @Lob
    private String name;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "SECOND_FORM_CHECK_BOX_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SecondFormCheckBox secondFormCheckBox;

    public SecondFormCheckBox getSecondFormCheckBox() {
        return secondFormCheckBox;
    }

    public void setSecondFormCheckBox(SecondFormCheckBox secondFormCheckBox) {
        this.secondFormCheckBox = secondFormCheckBox;
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