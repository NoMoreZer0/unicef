package com.company.unicef.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "PIVOT_TABLE_CHECK_BOXES", indexes = {
        @Index(name = "IDX_PIVOT_TABLE_CHECK_BOXES_SECOND_FORM", columnList = "SECOND_FORM_ID")
})
@Entity
public class PivotTableCheckBoxes {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "LEVEL_")
    private String level;

    @JoinColumn(name = "SECOND_FORM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SecondForm secondForm;

    public SecondForm getSecondForm() {
        return secondForm;
    }

    public void setSecondForm(SecondForm secondForm) {
        this.secondForm = secondForm;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}