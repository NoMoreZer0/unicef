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
@Table(name = "family_risk_factor")
public class FamilyRiskFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "yellow_family_risk_factor_id")
    private YellowFamilyRiskFactor yellowFamilyRiskFactor;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "green_family_risk_factor_id")
    private GreenFamilyRiskFactor greenFamilyRiskFactor;

    public Long countSectionScore(Long userScoreRed, Long userScoreGreen, Long userScoreYellow) throws IllegalAccessException {
        return this.greenFamilyRiskFactor.countScore(userScoreGreen)
                + this.yellowFamilyRiskFactor.countScore(userScoreYellow);
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
        FamilyRiskFactor that = (FamilyRiskFactor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}