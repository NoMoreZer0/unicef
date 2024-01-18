package com.company.unicef.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.FileRef;
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
@Table(name = "OPEN_CASE", indexes = {
        @Index(name = "IDX_OPEN_CASE_STUDENT", columnList = "STUDENT_ID"),
        @Index(name = "IDX_OPEN_CASE_SECOND_FORM", columnList = "SECOND_FORM_ID")
})
@Entity
public class OpenCase {
    @InstanceName
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "STUDENT_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Student student;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "SCHOOL_MASK")
    private String schoolMask;

    @Column(name = "OPENING_DATE")
    @Temporal(TemporalType.DATE)
    private Date openingDate;

    @Column(name = "CLOSING_DATE")
    @Temporal(TemporalType.DATE)
    private Date closingDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "WHO_STARTED")
    private String whoStarted;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "SECOND_FORM_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private SecondForm secondForm;

    @Column(name = "DOCUMENT", length = 1024)
    private FileRef document;

    @Composition
    @OneToMany(mappedBy = "openCase")
    private List<ResponsibleEmployee> responsibleEmployees;

    @Composition
    @OneToMany(mappedBy = "openCase")
    private List<Representatives> representatives;

    @Composition
    @OneToMany(mappedBy = "openCase", cascade = CascadeType.ALL)
    private List<SecondFormCheckBox> secondFormCheckBoxes = new ArrayList<>();

    public SchoolMask getSchoolMask() {
        return schoolMask == null ? null : SchoolMask.fromId(schoolMask);
    }

    public void setSchoolMask(SchoolMask schoolMask) {
        this.schoolMask = schoolMask == null ? null : schoolMask.getId();
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public List<Representatives> getRepresentatives() {
        return representatives;
    }

    public void setRepresentatives(List<Representatives> representatives) {
        this.representatives = representatives;
    }

    public List<ResponsibleEmployee> getResponsibleEmployees() {
        return responsibleEmployees;
    }

    public void setResponsibleEmployees(List<ResponsibleEmployee> responsibleEmployees) {
        this.responsibleEmployees = responsibleEmployees;
    }

    public List<SecondFormCheckBox> getSecondFormCheckBoxes() {
        return secondFormCheckBoxes;
    }

    public void setSecondFormCheckBoxes(List<SecondFormCheckBox> secondFormCheckBoxes) {
        this.secondFormCheckBoxes = secondFormCheckBoxes;
    }

    public FileRef getDocument() {
        return document;
    }

    public void setDocument(FileRef document) {
        this.document = document;
    }

    public SecondForm getSecondForm() {
        return secondForm;
    }

    public void setSecondForm(SecondForm secondForm) {
        this.secondForm = secondForm;
    }

    public String getWhoStarted() {
        return whoStarted;
    }

    public void setWhoStarted(String whoStarted) {
        this.whoStarted = whoStarted;
    }

    public CaseStatus getStatus() {
        return status == null ? null : CaseStatus.fromId(status);
    }

    public void setStatus(CaseStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}