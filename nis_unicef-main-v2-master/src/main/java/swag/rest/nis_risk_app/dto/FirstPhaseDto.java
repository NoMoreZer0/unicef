package swag.rest.nis_risk_app.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FirstPhaseDto {
    private StudentInformationDto studentInformationDto;
    private LegalRepresentativeDto legalRepresentative;
    private FamilyNeighborDto familyNeighbor;
    private SourceDto source;
    private String reason;
    private IndividualRiskFactorDto individualRiskFactor;
    private SocMedRiskFactorDto socMedRiskFactor;
    private FamilyRiskFactorDto familyRiskFactor;
    private AcademicRiskFactorDto academicRiskFactor;
    private IndividualSafeFactorDto individualSafeFactor;
    private FamilySafeFactorDto familySafeFactor;
    private EnvironmentSafeFactorDto environmentSafeFactor;
    private SchoolSafeFactorDto schoolSafeFactor;
    private ActionsDto actions;
    private String additionalComment;
}
