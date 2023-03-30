package swag.rest.nis_risk_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fourth_phase")
public class FourthPhase extends Phase {

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private String planReviewDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cases_id")
    private Case studentCase;

    private String educationalNeed;

    @OneToMany(targetEntity = OtherPersonLivingWithFamily.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "other_person_living_with_family_id", referencedColumnName = "id")
    private List<OtherPersonLivingWithFamily> otherPersonLivingWithFamilyList;

    @OneToMany(targetEntity = OutOfSchoolOrganizationEmployee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "out_of_school_organization_employee_id", referencedColumnName = "id")
    private List<OutOfSchoolOrganizationEmployee> outOfSchoolOrganizationEmployees;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "child_development_needs_id")
    private ChildDevelopmentNeeds childDevelopmentNeeds;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_skills_id")
    private ParentSkills parentSkills;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "opinion_of_involved_parties_id")
    private OpinionOfInvolvedParties opinionOfInvolvedParties;

    //Below fields from second form
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PartOfSecondForm partOfSecondForm;

    @Lob
    @Column(name = "document")
    @JsonIgnore
    private byte[] document;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FourthPhase that = (FourthPhase) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
