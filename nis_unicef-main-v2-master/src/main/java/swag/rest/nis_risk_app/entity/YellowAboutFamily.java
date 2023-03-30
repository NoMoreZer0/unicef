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
@Table(name = "yellow_about_family")
public class YellowAboutFamily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "avary_home")
    private Boolean avaryHome;
    @Column(name = "current_home_bad")
    private Boolean currentHomeBad;
    @Column(name = "parent_unemployed")
    private Boolean parentUnemployed;
    @Column(name = "family_no_take_needed_allowance")
    private Boolean familyNoTakeNeededAllowance;
    @Column(name = "have_material_issue")
    private Boolean haveMaterialIssue;

}
