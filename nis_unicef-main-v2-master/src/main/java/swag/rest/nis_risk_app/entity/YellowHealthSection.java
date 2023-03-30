package swag.rest.nis_risk_app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import swag.rest.nis_risk_app.util.HealthIssues;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "yellow_section")
public class YellowHealthSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "health_issues")
    @Enumerated(EnumType.STRING)
    private HealthIssues healthIssues;
    @Column(name = "have_health_issues")
    private Boolean haveHealthIssues;
    @Column(name = "no_chronic_attachment")
    private Boolean noChronicAttachment;
    @Column(name = "no_ped_soc_med")
    private Boolean noPedSocMed;
    @Column(name = "no_polyclinic_attachment")
    private Boolean noPolyclinicAttachment;
    @Column(name = "no_regular_health_check")
    private Boolean noRegularHealthCheck;
    @Column(name = "no_height_weight_ratio")
    private Boolean noHeightWeightRatio;
    @Column(name = "phobia")
    private Boolean phobia;
    @Column(name = "no_sleep")
    private Boolean noSleep;
    @Column(name = "trauma")
    private Boolean trauma;

}
