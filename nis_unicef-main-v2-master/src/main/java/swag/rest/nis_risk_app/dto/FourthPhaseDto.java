package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.FourthPhase} entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class FourthPhaseDto implements Serializable {
    private String date;
    private String planReviewDate;
    private String educationalNeed;
    private List<OtherPersonLivingWithFamilyDto> otherPersonLivingWithFamilyList;
    private List<OutOfSchoolOrganizationEmployeeDto> outOfSchoolOrganizationEmployees;
    private ChildDevelopmentNeedsDto childDevelopmentNeeds;
    private ParentSkillsDto parentSkills;
    private OpinionOfInvolvedPartiesDto opinionOfInvolvedParties;
}