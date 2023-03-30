package swag.rest.nis_risk_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Set;
import lombok.*;
import org.hibernate.Hibernate;
import swag.rest.nis_risk_app.util.CaseStatus;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cases_v2")
public class Case {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "opening_date")
    private Date openingDate;

    @Column(name = "closing_date")
    private Date closingDate;

    @Column(name = "openingReason")
    private String openingReason;

    @Column(name = "who_stated")
    private String whoStated;

    @Column(name = "caseStatus")
    @Enumerated(EnumType.STRING)
    private CaseStatus caseStatus;

    @Column(name = "closingReason")
    private String closingReason;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToMany
    @JoinTable(name = "users_case", joinColumns = @JoinColumn(name = "case_id"), inverseJoinColumns = @JoinColumn(name = "users_id"))
    @ToString.Exclude
    @JsonIgnore
    private List<Users> users;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users caseManager;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private FirstPhase firstForm;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @ToString.Exclude
    private Set<SecondPhase> secondPhases;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @ToString.Exclude
    private Set<FourthPhase> fourthPhases;

    @OneToMany(mappedBy = "studentCase", fetch = FetchType.EAGER)
    @JsonIgnore
    @ToString.Exclude
    private List<CaseMeetings> caseMeetings;

    public Case(Date openingDate, Date closingDate, String openingReason, String whoStated, Student student, List<Users> users) {
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.openingReason = openingReason;
        this.whoStated = whoStated;
        this.student = student;
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Case aCase = (Case) o;
        return id != null && Objects.equals(id, aCase.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
