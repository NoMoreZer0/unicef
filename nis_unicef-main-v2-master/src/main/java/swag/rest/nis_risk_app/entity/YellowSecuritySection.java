package swag.rest.nis_risk_app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "yellow_security_section")
public class YellowSecuritySection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "have_education_env")
    private Boolean haveEducationEnv;
    @Column(name = "frequent_school_change")
    private Boolean frequentSchoolChange;
    @Column(name = "parent_no_interest_where")
    private Boolean parentNoInterestWhere;
    @Column(name = "no_law_family")
    private Boolean noLawFamily;

}
