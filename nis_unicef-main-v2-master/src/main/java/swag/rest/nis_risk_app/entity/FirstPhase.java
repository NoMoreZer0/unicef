package swag.rest.nis_risk_app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import swag.rest.nis_risk_app.util.StudentStatus;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "first_phase_v2")
public class FirstPhase extends Phase implements Comparable<FirstPhase> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "draft")
    private Boolean draft;

    @Column(name = "start_date")
    String startDate;

    @Column(name = "end_date")
    String endDate;

    @OneToOne(cascade = CascadeType.DETACH)
    private StudentInformation studentInformation;

    @ManyToOne
    @JoinColumn(name = "legal_representative_id")
    private LegalRepresentative legalRepresentative;

    @ManyToOne
    @JoinColumn(name = "family_neighbor_id")
    private FamilyNeighbor familyNeighbor;

    @Column(name = "reason")
    private String reason;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "source_id")
    private Source source;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "individual_risk_factor_id")
    private IndividualRiskFactor individualRiskFactor;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "med_risk_factor_id")
    private SocMedRiskFactor socMedRiskFactor;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "family_risk_factor_id")
    private FamilyRiskFactor familyRiskFactor;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "academic_risk_factor_id")
    private AcademicRiskFactor academicRiskFactor;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "individual_safe_factor_id")
    private IndividualSafeFactor individualSafeFactor;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "family_safe_factor_id")
    private FamilySafeFactor familySafeFactor;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "environment_safe_factor_id")
    private EnvironmentSafeFactor environmentSafeFactor;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "school_safe_factor_id")
    private SchoolSafeFactor schoolSafeFactor;

    private String additionalComment;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "actions_ID")
    private Actions actions;

    @Column(name = "case_manager")
    private String caseManager;

    @Lob
    @Column(name = "sign")
    @JsonIgnore
    private byte[] sign;

    @Lob
    @Column(name = "document")
    @JsonIgnore
    private byte[] document;

    @Column(name = "sign_date")
    private String signDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cases_id", nullable=true)
    private Case studentCase;

    @OneToOne
    @JoinColumn(name = "users_id")
    private Users user;

    private StudentStatus studentStatusRisk;


    @JsonIgnore
    public Boolean isRiskStatusHigh(){
        return socMedRiskFactor.getRedRiskStatus()
                || individualRiskFactor.getRedRiskStatus();
    }

    @JsonIgnore
    public Boolean isRiskStatusYellow(){
        return academicRiskFactor.getYellowRiskStatus()
                || familyRiskFactor.getYellowRiskStatus()
                || socMedRiskFactor.getYellowRiskStatus()
                || individualRiskFactor.getYellowRiskStatus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FirstPhase that = (FirstPhase) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public int compareTo(FirstPhase o) {
        return this.id.compareTo(o.id);
    }
}



