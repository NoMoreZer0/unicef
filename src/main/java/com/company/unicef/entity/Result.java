package com.company.unicef.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "RESULT_", indexes = {
        @Index(name = "IDX_RESULT__EVENT", columnList = "EVENT_ID")
})
@Entity(name = "Result_")
public class Result {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "SUCCESS_INDICATOR")
    @Lob
    private String successIndicator;

    @Column(name = "GRADE_FIRST_TERM")
    private String gradeFirstTerm;

    @Column(name = "GRADE_SECOND_TERM")
    private String gradeSecondTerm;

    @Column(name = "GRADE_THIRD_TERM")
    private String gradeThirdTerm;

    @Column(name = "GRADE_FOURTH_TERM")
    private String gradeFourthTerm;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "EVENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    public GradeFourthTerm getGradeFourthTerm() {
        return gradeFourthTerm == null ? null : GradeFourthTerm.fromId(gradeFourthTerm);
    }

    public void setGradeFourthTerm(GradeFourthTerm gradeFourthTerm) {
        this.gradeFourthTerm = gradeFourthTerm == null ? null : gradeFourthTerm.getId();
    }

    public GradeThirdTerm getGradeThirdTerm() {
        return gradeThirdTerm == null ? null : GradeThirdTerm.fromId(gradeThirdTerm);
    }

    public void setGradeThirdTerm(GradeThirdTerm gradeThirdTerm) {
        this.gradeThirdTerm = gradeThirdTerm == null ? null : gradeThirdTerm.getId();
    }

    public GradeSecondTerm getGradeSecondTerm() {
        return gradeSecondTerm == null ? null : GradeSecondTerm.fromId(gradeSecondTerm);
    }

    public void setGradeSecondTerm(GradeSecondTerm gradeSecondTerm) {
        this.gradeSecondTerm = gradeSecondTerm == null ? null : gradeSecondTerm.getId();
    }

    public GradeFirstTerm getGradeFirstTerm() {
        return gradeFirstTerm == null ? null : GradeFirstTerm.fromId(gradeFirstTerm);
    }

    public void setGradeFirstTerm(GradeFirstTerm gradeFirstTerm) {
        this.gradeFirstTerm = gradeFirstTerm == null ? null : gradeFirstTerm.getId();
    }

    public String getSuccessIndicator() {
        return successIndicator;
    }

    public void setSuccessIndicator(String successIndicator) {
        this.successIndicator = successIndicator;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}