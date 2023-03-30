package swag.rest.nis_risk_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import swag.rest.nis_risk_app.entity.SocMedRiskFactor;

import java.io.Serializable;

/**
 * A DTO for the {@link SocMedRiskFactor} entity
 */
@AllArgsConstructor
@Getter
@ToString
public class MedRiskFactorDto implements Serializable {
    private Boolean sexualTransaction;
    private Boolean sexualAbuse;
    private Boolean suicideAttempt;
    private Boolean isPhysicallyOk;
    private Boolean isDisabledPerson;
    private Boolean isEatWell;
    private Boolean drinkAlcohol;
    private Boolean useDrugs;
    private Boolean feelStressedOnExam;
}
