package swag.rest.nis_risk_app.helper;

import de.phip1611.Docx4JSRUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import swag.rest.nis_risk_app.entity.ChildDevelopmentPlan;
import swag.rest.nis_risk_app.entity.FourthPhase;
import swag.rest.nis_risk_app.entity.RatingScale;
import swag.rest.nis_risk_app.util.Gender;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FourthFormGenerator implements FormGenerator<FourthPhase> {
    Map map;

    @Override
    public void generatePdf(WordprocessingMLPackage wordMLPackage, FourthPhase fourthPhase) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        map = new HashMap();
        map.put("$caseId#", fourthPhase.getStudentCase().getId() + "");
        map.put("$school#",
            fourthPhase.getStudentCase().getStudent().getSchool() == null ? "Не указано" :
                fourthPhase.getStudentCase().getStudent().getSchool());
        map.put("$caseManagerFio#",
            fourthPhase.getStudentCase().getCaseManager().getFio() == null ? "Не указано" :
                fourthPhase.getStudentCase().getCaseManager().getFio());
        map.put("$caseManagerPhoneNumber#",
            fourthPhase.getStudentCase().getCaseManager().getPhoneNumber() == null ? "Не указано" :
                fourthPhase.getStudentCase().getCaseManager().getPhoneNumber());
        map.put("$fio#",
            fourthPhase.getStudentCase().getStudent().nameOfStudent() == null ? "Не указано" :
                fourthPhase.getStudentCase().getStudent().nameOfStudent());
        map.put("$birthDate#",
            fourthPhase.getStudentCase().getStudent().dateOfBirth() == null ? "Не указано" :
                fourthPhase.getStudentCase().getStudent().dateOfBirth());
        map.put("$age#",
            fourthPhase.getStudentCase().getStudent().dateOfBirth() == null ? "Не указано" :
                String.valueOf(
                    ChronoUnit.YEARS.between(
                        LocalDate.parse(fourthPhase.getStudentCase().getStudent().dateOfBirth(),
                            format),
                        LocalDateTime.now().toLocalDate())));
        if (fourthPhase.getStudentCase().getStudent().getGender() == Gender.FEMALE) {
            map.put("$genderW#", "Жен");
            map.put("$genderM#", "");
        } else {
            map.put("$genderW#", "");
            map.put("$genderM#", "Муж");
        }
        //TODO educational need if else
        if (fourthPhase.getEducationalNeed() == "Да") {
            map.put("$educationalNeedYes#", "✓");
            map.put("$educationalNeedNo#", "");
            map.put("$educationalNeedNoInfo#", "");
            map.put("$educationalNeedOther#", "");
        } else if (fourthPhase.getEducationalNeed() == "Нет") {
            map.put("$educationalNeedYes#", "");
            map.put("$educationalNeedNo#", "✓");
            map.put("$educationalNeedNoInfo#", "");
            map.put("$educationalNeedOther#", "");
        } else if (fourthPhase.getEducationalNeed() == "Нет инф") {
            map.put("$educationalNeedYes#", "");
            map.put("$educationalNeedNo#", "");
            map.put("$educationalNeedNoInfo#", "✓");
            map.put("$educationalNeedOther#", "");
        } else {
            map.put("$educationalNeedYes#", "");
            map.put("$educationalNeedNo#", "");
            map.put("$educationalNeedNoInfo#", "");
            map.put("$educationalNeedOther#", fourthPhase.getEducationalNeed());
        }
        map.put("$studentAddress#",
            fourthPhase.getStudentCase().getStudent().getAddress() == null ? "Не указано" :
                fourthPhase.getStudentCase().getStudent().getAddress());
        map.put("$studentPhoneNumber#",
            fourthPhase.getStudentCase().getStudent().getPhoneNumber() == null ? "Не указано" :
                fourthPhase.getStudentCase().getStudent().getPhoneNumber());

        map.put("$otherPersonLivingWithFamilyFio#",
            fourthPhase.getOtherPersonLivingWithFamilyList().get(0).getFio());
        map.put("$otherPersonLivingWithFamilyBirthDate#",
            fourthPhase.getOtherPersonLivingWithFamilyList().get(0).getBirthDate());
        map.put("$otherPersonLivingWithFamilyRelationLevel#",
            fourthPhase.getOtherPersonLivingWithFamilyList().get(0).getRelationLevel());
        map.put("$otherPersonLivingWithFamilyWorkplace#",
            fourthPhase.getOtherPersonLivingWithFamilyList().get(0).getWorkplace());

        for (int i = 0; i < fourthPhase.getStudentCase().getUsers().size(); i++) {
            if (i == 3) {
                break;
            } else if (fourthPhase.getStudentCase().getUsers().size() < 2) {
                for (int j = fourthPhase.getStudentCase().getUsers().size(); j < 3; j++) {
                    map.put("$userFio" + j + "#", "");
                    map.put("$userPosition" + j + "#", "");
                    map.put("$userPhoneNumber" + j + "#", "");
                }
            }
            map.put("$userFio" + i + "#",
                fourthPhase.getStudentCase().getUsers().get(i).getFio() == null ? "Не указано" :
                    fourthPhase.getStudentCase().getUsers().get(i).getFio());
            map.put("$userPosition" + i + "#",
                fourthPhase.getStudentCase().getUsers().get(i).getPosition() == null ?
                    "Не указано" : fourthPhase.getStudentCase().getUsers().get(i).getPosition());
            map.put("$userPhoneNumber" + i + "#",
                fourthPhase.getStudentCase().getUsers().get(i).getPhoneNumber() == null ?
                    "Не указано" : fourthPhase.getStudentCase().getUsers().get(i).getPhoneNumber());
        }

        for (int k = 0; k < fourthPhase.getOutOfSchoolOrganizationEmployees().size(); k++) {
            if (k == 5) {
                break;
            } else if (fourthPhase.getOutOfSchoolOrganizationEmployees().size() < 4) {
                for (int l = fourthPhase.getOutOfSchoolOrganizationEmployees().size(); l < 5; l++) {
                    map.put("$outOfSchoolOrganizationEmployeeFio" + l + "#", "");
                    map.put("$outOfSchoolOrganizationEmployeeOrganization" + l + "#", "");
                    map.put("$outOfSchoolOrganizationEmployeeContact" + l + "#", "");
                }
            }
            map.put("$outOfSchoolOrganizationEmployeeFio" + k + "#",
                fourthPhase.getOutOfSchoolOrganizationEmployees().get(k).getFio());
            map.put("$outOfSchoolOrganizationEmployeeOrganization" + k + "#",
                fourthPhase.getOutOfSchoolOrganizationEmployees().get(k).getOrganization());
            map.put("$outOfSchoolOrganizationEmployeeContact" + k + "#",
                fourthPhase.getOutOfSchoolOrganizationEmployees().get(k).getContact());
        }

        modifySection("health", fourthPhase.getChildDevelopmentNeeds().getHealthForm4());
        modifySection("education", fourthPhase.getChildDevelopmentNeeds().getEducationForm4());
        modifySection("emotionalDevelopment",
            fourthPhase.getChildDevelopmentNeeds().getEmotionalDevelopmentForm4());
        modifySection("identity", fourthPhase.getChildDevelopmentNeeds().getIdentityForm4());
        modifySection("family", fourthPhase.getChildDevelopmentNeeds().getFamilyForm4());
        modifySection("socialPresentation",
            fourthPhase.getChildDevelopmentNeeds().getSocialPresentationForm4());
        modifySection("selfIndependence",
            fourthPhase.getChildDevelopmentNeeds().getSelfIndependenceForm4());

        modifySection("basicCare", fourthPhase.getParentSkills().getBasicCareForm4());
        modifySection("security", fourthPhase.getParentSkills().getSecurityForm4());
        modifySection("emotionalHeat", fourthPhase.getParentSkills().getEmotionalHeatForm4());
        modifySection("stability", fourthPhase.getParentSkills().getSecurityForm4());
        modifySection("directionBorders", fourthPhase.getParentSkills().getDirectionBordersForm4());
        modifySection("stimulation", fourthPhase.getParentSkills().getStimulationForm4());
        modifySection("parentProblems", fourthPhase.getParentSkills().getParentProblemsForm4());
        modifySection("housingWorkIncome",
            fourthPhase.getParentSkills().getHousingWorkIncomeForm4());
        modifySection("familyHistory", fourthPhase.getParentSkills().getFamilyHistoryForm4());
        modifySection("extendedFamily", fourthPhase.getParentSkills().getExtendedFamilyForm4());
        modifySection("resources", fourthPhase.getParentSkills().getResourcesForm4());
        modifySection("socialIntegration",
            fourthPhase.getParentSkills().getSocialIntegrationForm4());

        map.put("$childComment#", fourthPhase.getOpinionOfInvolvedParties().getChildComment());
        map.put("$organizationComment#",
            fourthPhase.getOpinionOfInvolvedParties().getOrganizationComment());
        map.put("$parentComment#", fourthPhase.getOpinionOfInvolvedParties().getParentComment());

        if (fourthPhase.getStudentCase().getStudent().getParents().size() > 1) {
            map.put("$parentFio1#",
                fourthPhase.getStudentCase().getStudent().getParents().get(0).getNameOfParent());
            map.put("$parentFio2#",
                fourthPhase.getStudentCase().getStudent().getParents().get(1).getNameOfParent());
        } else if (fourthPhase.getStudentCase().getStudent().getParents().size() == 1) {
            map.put("$parentFio1#",
                fourthPhase.getStudentCase().getStudent().getParents().get(0).getNameOfParent());
            map.put("$parentFio2#", "");
        } else {
            map.put("$parentFio1#", "");
            map.put("$parentFio2#", "");
        }

        Docx4JSRUtil.searchAndReplace(wordMLPackage, map);
    }

    public void modifySection(String name, ChildDevelopmentPlan section) {
        map.put("$" + name + "Criteria#", section.criteria + "");
        map.put("$" + name + "RiskFactors#", section.discoveredRiskFactors);
        map.put("$" + name + "Measures#", section.measures);
        map.put("$" + name + "MeasurePeriod#", section.measurePeriod);
        map.put("$" + name + "Employee#", section.employee);
        String ratingScale;
        if (section.ratingScale == RatingScale.DONE_WITH_PROGRESS) {
            ratingScale =
                "Мероприятие выполнено с прогрессом сверх нормы (автоматом закрашивается 3)";
        } else if (section.ratingScale == RatingScale.DONE_WITH_SUCCESS) {
            ratingScale =
                "Мероприятие выполнено, есть значительный сдвиг в сторону успешности (автоматом закрашивается на 1 единицу больше предыдущего результата)";
        } else if (section.ratingScale == RatingScale.DONE_SAME) {
            ratingScale =
                "Мероприятие выполнено, но результат на том же месте (автоматом остается та же цифра)";
        } else if (section.ratingScale == RatingScale.DONE_GET_BAD) {
            ratingScale =
                "Мероприятие выполнено, но результат стал хуже (автоматом цифра на 1 единицу ниже)";
        } else {
            ratingScale =
                "Мероприятие не выполнено (автоматом какое-то обозначение зоны, что она не работала, каким-то цветом мигает или как-то чтобы выдедялась).";
        }
        map.put("$" + name + "RatingScale#", ratingScale);
        map.put("$" + name + "Indicator#", section.indicator + "");
    }
}
