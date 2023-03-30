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
@Table(name = "yellow_education_section")
public class YellowEducationSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "part_time")
    private Boolean partTime;

    @Column(name = "no_discipline")
    private Boolean noDiscipline;

    @Column(name = "no_concentration")
    private Boolean noConcentration;

    @Column(name = "no_kancellary")
    private Boolean noKancellary;
    @Column(name = "no_computer")
    private Boolean noComputer;
    @Column(name = "no_uniform")
    private Boolean noUniform;
    @Column(name = "teacher_conflict")
    private Boolean teacherConflict;
    @Column(name = "no_homework_space")
    private Boolean noHomeworkSpace;
    @Column(name = "no_motivation")
    private Boolean noMotivation;

}
