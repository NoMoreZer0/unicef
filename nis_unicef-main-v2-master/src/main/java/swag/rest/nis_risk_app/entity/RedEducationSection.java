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
@Table(name = "red_education_section")
public class RedEducationSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "no_like_attend")
    private Boolean noLikeAttend;

    @Column(name = "special_need")
    private Boolean specialNeed;

    @Column(name = "studying_trouble")
    private Boolean studyingTrouble;

    @Column(name = "often_miss")
    private Boolean oftenMiss;
}
