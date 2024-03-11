package com.company.unicef.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "EVENT_TABLE", indexes = {
        @Index(name = "IDX_EVENT_SECOND_FORM_CHECK_BOX", columnList = "SECOND_FORM_CHECK_BOX_ID")
})
@Entity
public class Event {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Composition
    @OneToMany(mappedBy = "event")
    private List<EventDate> eventDate;

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @Composition
    @OneToMany(mappedBy = "event")
    private List<Parent> parents;

    @Column(name = "PERIODICITY")
    @Lob
    private String periodicity;

    @Column(name = "STARTING_PERIOD")
    @Temporal(TemporalType.DATE)
    private Date startingPeriod;

    @Column(name = "ENDING_PERIOD")
    @Temporal(TemporalType.DATE)
    private Date endingPeriod;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "event")
    private List<Result> eventResults = new ArrayList<>();

    @OneToMany(mappedBy = "event")
    private List<EventUser> eventUsers = new ArrayList<>();

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "SECOND_FORM_CHECK_BOX_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SecondFormCheckBox secondFormCheckBox;

    public List<EventDate> getEventDate() {
        return eventDate;
    }

    public void setEventDate(List<EventDate> eventDate) {
        this.eventDate = eventDate;
    }

    public List<EventUser> getEventUsers() {
        return eventUsers;
    }

    public void setEventUsers(List<EventUser> eventUsers) {
        this.eventUsers = eventUsers;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public List<Result> getEventResults() {
        return eventResults;
    }

    public void setEventResults(List<Result> eventResults) {
        this.eventResults = eventResults;
    }

    public Date getEndingPeriod() {
        return endingPeriod;
    }

    public void setEndingPeriod(Date endingPeriod) {
        this.endingPeriod = endingPeriod;
    }

    public Date getStartingPeriod() {
        return startingPeriod;
    }

    public void setStartingPeriod(Date startingPeriod) {
        this.startingPeriod = startingPeriod;
    }

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