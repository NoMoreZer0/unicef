package swag.rest.nis_risk_app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "red_health_section_v2")
public class RedHealthSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "not_eat_well")
    private Boolean notEatWell;

    @Column(name = "no_glasses")
    private Boolean noGlasses;

    @Column(name = "bad_coordination")
    private Boolean badCoordination;

    @Column(name = "bad_habits")
    private Boolean badHabits;

    @Column(name = "incontinence")
    private Boolean incontinence;

    @Column(name = "speech_issues")
    private Boolean speechIssues;

}
