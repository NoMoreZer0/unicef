package swag.rest.nis_risk_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "out_of_school_organization_employee")
public class OutOfSchoolOrganizationEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fio;
    private String organization;
    private String contact;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fourth_phase_id")
    @JsonIgnore
    private FourthPhase fourthPhase;
}
