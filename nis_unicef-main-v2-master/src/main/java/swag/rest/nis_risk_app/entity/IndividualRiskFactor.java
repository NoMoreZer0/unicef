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
@Table(name = "individual_risk_factor")
public class IndividualRiskFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "red_individual_risk_factor_id")
    private RedIndividualRiskFactor redIndividualRiskFactor;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "yellow_individual_risk_factor_id")
    private YellowIndividualRiskFactor yellowIndividualRiskFactor;

    public Long countSectionScore(Long userScoreRed, Long userScoreGreen, Long userScoreYellow) throws IllegalAccessException {
        return this.redIndividualRiskFactor.countScore(userScoreRed)
                + this.yellowIndividualRiskFactor.countScore(userScoreYellow);
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
        IndividualRiskFactor that = (IndividualRiskFactor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}