package com.company.unicef.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@JmixEntity
@Table(name = "SECOND_FORM_CHECK_BOX", indexes = {
        @Index(name = "IDX_SECOND_FORM_CHECK_BOX_OPEN_CASE", columnList = "OPEN_CASE_ID")
})
@Entity
public class SecondFormCheckBox {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @Column(name = "CATEGORY")
    private String category;

    @OneToMany(mappedBy = "secondFormCheckBox")
    private Set<NeedNames> needNames;

    @Column(name = "GOAL_TEXT")
    private String goalText;

    @Composition
    @OneToMany(mappedBy = "secondFormCheckBox")
    private List<Event> secondFormEvents = new ArrayList<>();

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "OPEN_CASE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private OpenCase openCase;

    public void setNeedNames(Set<NeedNames> needNames) {
        this.needNames = needNames;
    }

    public Set<NeedNames> getNeedNames() {
        return needNames;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Event> getSecondFormEvents() {
        return secondFormEvents;
    }

    public void setSecondFormEvents(List<Event> secondFormEvents) {
        this.secondFormEvents = secondFormEvents;
    }

    public String getGoalText() {
        return goalText;
    }

    public void setGoalText(String goalText) {
        this.goalText = goalText;
    }

    public OpenCase getOpenCase() {
        return openCase;
    }

    public void setOpenCase(OpenCase openCase) {
        this.openCase = openCase;
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