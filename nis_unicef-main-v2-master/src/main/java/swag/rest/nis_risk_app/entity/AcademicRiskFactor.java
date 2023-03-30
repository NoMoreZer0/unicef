package swag.rest.nis_risk_app.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "academic_risk_factor")
public class AcademicRiskFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "yellow_academic_risk_factor_id")
    private YellowAcademicRiskFactor yellowAcademicRiskFactor;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "green_academic_risk_factor_id")
    private GreenAcademicRiskFactor greenAcademicRiskFactor;

    public Long countSectionScore(Long userScoreRed, Long userScoreGreen, Long userScoreYellow) throws IllegalAccessException {
        return this.greenAcademicRiskFactor.countScore(userScoreGreen)
                + this.yellowAcademicRiskFactor.countScore(userScoreYellow);
    }

    public Boolean getRedRiskStatus(){
        return true; //TODO
    }

    public Boolean getYellowRiskStatus(){
        return true; //TODO
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademicRiskFactor that = (AcademicRiskFactor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}