package swag.rest.nis_risk_app.helper;

import de.phip1611.Docx4JSRUtil;
import lombok.extern.slf4j.Slf4j;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import swag.rest.nis_risk_app.entity.FirstPhase;
import swag.rest.nis_risk_app.util.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import static java.util.Map.entry;

@Slf4j
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FirstFormGenerator implements FormGenerator<FirstPhase> {

    @Override
    public void generatePdf(WordprocessingMLPackage wordMLPackage, FirstPhase firstPhase) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        log.info(firstPhase.getLegalRepresentative()
                .father()
                .dateOfBirth() + " - father age");

        Docx4JSRUtil.searchAndReplace(wordMLPackage, Map.ofEntries(
                entry("$openingDate#", firstPhase.getStartDate()),
                entry("$FIO#", firstPhase.getStudentInformation().getNameOfStudent()),
                entry("$endDate#", firstPhase.getEndDate()),
                entry("$birthDate#", firstPhase.getStudentInformation().getDateOfBirth()),
                entry("$age#",  String.valueOf(
                        ChronoUnit.YEARS.between(LocalDate.parse(firstPhase.getStudentInformation().dateOfBirth(), format),
                                        LocalDateTime.now().toLocalDate()))),
                entry("$grade#", firstPhase.getStudentInformation().grade()),
                entry("$gender#",
                        firstPhase.getStudentInformation().gender() == Gender.MALE  ? "Муж" : "Жен"),
                entry("$eduNeeds#", firstPhase.getStudentInformation().educationalNeeds()),
                entry("$address#", firstPhase.getStudentInformation().address()),
                entry("$contacts#", firstPhase.getStudentInformation().phoneNumber()),
                entry("$fatherName#", firstPhase.getLegalRepresentative().father().nameOfParent()),
                entry("$fatherDate#", firstPhase.getLegalRepresentative().father().dateOfBirth()),
                entry("$fatherAge#", String.valueOf(
                        Period.between(LocalDate.parse(firstPhase.getLegalRepresentative()
                                                        .father().dateOfBirth(), format), LocalDateTime.now().toLocalDate())
                                .getYears())),
                entry("$fatherStatus#", firstPhase.getLegalRepresentative().father().familyStatus()),
                entry("$fatherAddress#", firstPhase.getLegalRepresentative().father().address()),
                entry("$realFather#", firstPhase.getLegalRepresentative().father().getRealFather() == Boolean.TRUE ? "Да" : "Нет"),
                entry("$motherName#", firstPhase.getLegalRepresentative().mother().nameOfParent()),
                entry("$motherDate#", firstPhase.getLegalRepresentative()
                        .mother().dateOfBirth()),
                entry("$motherAge#", String.valueOf(
                        Period.between(LocalDate.parse(firstPhase.getLegalRepresentative()
                                                        .mother()
                                                        .dateOfBirth(), format), LocalDateTime.now().toLocalDate())
                                .getYears())),
                entry("$motherStatus#", firstPhase.getLegalRepresentative().mother().familyStatus()),
                entry("$motherAddress#", firstPhase.getLegalRepresentative().mother().address()),
                entry("$realMother#", firstPhase.getLegalRepresentative().mother().getRealMother() == Boolean.TRUE ? "Да" : "Нет"),
                entry("$otherPerson#",firstPhase.getLegalRepresentative().otherPerson().getNameOfParent()),
                entry("$otherAge#",String.valueOf(
                        Period.between(LocalDate.parse(firstPhase.getLegalRepresentative()
                                                        .otherPerson()
                                                        .dateOfBirth(), format),
                                        LocalDateTime.now().toLocalDate())
                                .getYears())),
                entry("$whoExactly#",firstPhase.getLegalRepresentative().otherPerson().getWhoExactly()),
                entry("$workplace#",firstPhase.getLegalRepresentative().otherPerson().getWorkplace()),
                entry("$reason#",firstPhase.getReason()),
                entry("$dateOfMeeting#", firstPhase.getSource().getDateOfMeeting()),
                entry("$nameOfPerson#", firstPhase.getSource().getNameOfPerson()),
                entry("$organization#", firstPhase.getSource().getOrganization()),
                entry("$connectionWithStudent#", firstPhase.getSource().getConnectionWithStudent()),
                entry("$contact#", firstPhase.getSource().getContact()),


                entry("$legalIssues#", firstPhase.getSocMedRiskFactor().getGreenSocMedRiskFactor().getLegalIssues() ? "✓" : "✗"),
                entry("$lawConflict#", firstPhase.getSocMedRiskFactor().getYellowSocMedRiskFactor().getLawConflict() ? "✓" : "✗"),
                entry("$earlyPregnancy#", firstPhase.getSocMedRiskFactor().getYellowSocMedRiskFactor().getEarlyPregnancy() ? "✓" : "✗"),
                entry("$invalid#", firstPhase.getSocMedRiskFactor().getYellowSocMedRiskFactor().getInvalid() ? "✓" : "✗"),
                entry("$hasHiv#", firstPhase.getSocMedRiskFactor().getYellowSocMedRiskFactor().getHasHiv() ? "✓" : "✗"),
                entry("$badEating#", firstPhase.getSocMedRiskFactor().getYellowSocMedRiskFactor().getBadEating() ? "✓" : "✗"),
                entry("$noOutfit#", firstPhase.getSocMedRiskFactor().getGreenSocMedRiskFactor().getNoOutfit() ? "✓" : "✗"),
                entry("$withoutCareRisk#", firstPhase.getSocMedRiskFactor().getRedSocMedRiskFactor().getWithoutCareRisk() ? "✓" : "✗"),
                entry("$childLabour#", firstPhase.getSocMedRiskFactor().getRedSocMedRiskFactor().getChildLabour() ? "✓" : "✗"),
                entry("$domesticViolence#", firstPhase.getSocMedRiskFactor().getRedSocMedRiskFactor().getDomesticViolence() ? "✓" : "✗"),
                entry("$violentApproach#", firstPhase.getSocMedRiskFactor().getYellowSocMedRiskFactor().getViolentApproach() ? "✓" : "✗"),
                entry("$fosterCareExperience#", firstPhase.getSocMedRiskFactor().getYellowSocMedRiskFactor().getFosterCareExperience() ? "✓" : "✗"),
                entry("$psychicalIssue#", firstPhase.getSocMedRiskFactor().getYellowSocMedRiskFactor().getPsychicalIssue() ? "✓" : "✗"),
                entry("$exploitation#", firstPhase.getSocMedRiskFactor().getRedSocMedRiskFactor().getExploitation() ? "✓" : "✗"),
                entry("$religious#", firstPhase.getSocMedRiskFactor().getYellowSocMedRiskFactor().getReligious() ? "✓" : "✗"),
                entry("$warRefugeeKid#", firstPhase.getSocMedRiskFactor().getYellowSocMedRiskFactor().getWarRefugee() ? "✓" : "✗"),
                entry("$liveOutsideFamily#", firstPhase.getSocMedRiskFactor().getGreenSocMedRiskFactor().getLiveOutsideFamily() ? "✓" : "✗"),

                entry("$selfHarm#", firstPhase.getIndividualRiskFactor().getYellowIndividualRiskFactor().getSelfHarm() ? "✓" : "✗"),
                entry("$riskyBehaviour#", firstPhase.getIndividualRiskFactor().getRedIndividualRiskFactor().getRiskyBehaviour() ? "✓" : "✗"),
                entry("$suicideRisk#", firstPhase.getIndividualRiskFactor().getRedIndividualRiskFactor().getSuicideRisk() ? "✓" : "✗"),
                entry("$grief#", firstPhase.getIndividualRiskFactor().getYellowIndividualRiskFactor().getGrief() ? "✓" : "✗"),
                entry("$bullied#", firstPhase.getIndividualRiskFactor().getYellowIndividualRiskFactor().getBullied() ? "✓" : "✗"),
                entry("$stressTrauma#", firstPhase.getIndividualRiskFactor().getYellowIndividualRiskFactor().getStressTrauma() ? "✓" : "✗"),
                entry("$physMentalDisorder#", firstPhase.getIndividualRiskFactor().getYellowIndividualRiskFactor().getPhysMentalDisorder() ? "✓" : "✗"),
                entry("$weakSelfService#", firstPhase.getIndividualRiskFactor().getYellowIndividualRiskFactor().getWeakSelfService() ? "✓" : "✗"),
                entry("$psychoemotional#", firstPhase.getIndividualRiskFactor().getYellowIndividualRiskFactor().getPsychoemotional() ? "✓" : "✗"),

                entry("$absenceWithoutExcuse#", firstPhase.getAcademicRiskFactor().getYellowAcademicRiskFactor().getAbsenceWithoutExcuse() ? "✓" : "✗"),
                entry("$unsatisfactoryGrades#", firstPhase.getAcademicRiskFactor().getYellowAcademicRiskFactor().getUnsatisfactoryGrades() ? "✓" : "✗"),
                entry("$absenceHealth#", firstPhase.getAcademicRiskFactor().getGreenAcademicRiskFactor().getAbsenceHealth() ? "✓" : "✗"),
                entry("$notProvided#", firstPhase.getAcademicRiskFactor().getGreenAcademicRiskFactor().getNotProvided() ? "✓" : "✗"),
                entry("$lowMotivation#", firstPhase.getAcademicRiskFactor().getYellowAcademicRiskFactor().getLowMotivation() ? "✓" : "✗"),
                entry("$s2sConflict#", firstPhase.getAcademicRiskFactor().getYellowAcademicRiskFactor().getS2sConflict() ? "✓" : "✗"),
                entry("$noParentalControl#", firstPhase.getAcademicRiskFactor().getYellowAcademicRiskFactor().getNoParentalControl() ? "✓" : "✗"),
                entry("$noSchoolSessions#", firstPhase.getAcademicRiskFactor().getGreenAcademicRiskFactor().getNoSchoolSessions() ? "✓" : "✗"),
                entry("$refuseSchoolSession#", firstPhase.getAcademicRiskFactor().getGreenAcademicRiskFactor().getRefuseSchoolSession() ? "✓" : "✗"),
                entry("$lowQualitySchoolSession#", firstPhase.getAcademicRiskFactor().getGreenAcademicRiskFactor().getLowQualitySchoolSession() ? "✓" : "✗"),
                entry("$t2pConflict#", firstPhase.getAcademicRiskFactor().getYellowAcademicRiskFactor().getT2pConflict() ? "✓" : "✗"),
                entry("$s2tConflict#", firstPhase.getAcademicRiskFactor().getYellowAcademicRiskFactor().getS2tConflict() ? "✓" : "✗"),

                entry("$manyKids#", firstPhase.getFamilyRiskFactor().getGreenFamilyRiskFactor().getManyKids() ? "✓" : "✗"),
                entry("$migrantParents#", firstPhase.getFamilyRiskFactor().getGreenFamilyRiskFactor().getMigrantParents() ? "✓" : "✗"),
                entry("$alcoNarco#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getAlcoNarco() ? "✓" : "✗"),
                entry("$imprisonedParents#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getImprisonedParents() ? "✓" : "✗"),
                entry("$homelessParents#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getHomelessParents() ? "✓" : "✗"),
                entry("$uneducatedParents#", firstPhase.getFamilyRiskFactor().getGreenFamilyRiskFactor().getUneducatedParents() ? "✓" : "✗"),
                entry("$weakParents#", firstPhase.getFamilyRiskFactor().getGreenFamilyRiskFactor().getWeakParents() ? "✓" : "✗"),
                entry("$failedBonding#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getFailedBonding() ? "✓" : "✗"),
                entry("$divorcedParents#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getDivorcedParents() ? "✓" : "✗"),
                entry("$badHousing#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getBadHousing() ? "✓" : "✗"),
                entry("$badMedicals#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getBadMedicals() ? "✓" : "✗"),
                entry("$noTransport#", firstPhase.getFamilyRiskFactor().getGreenFamilyRiskFactor().getNoTransport() ? "✓" : "✗"),
                entry("$financialProblem#", firstPhase.getFamilyRiskFactor().getGreenFamilyRiskFactor().getFinancialProblem() ? "✓" : "✗"),
                entry("$culturalNorms#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getCulturalNorms() ? "✓" : "✗"),
                entry("$psychoParents#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getPsychoParents() ? "✓" : "✗"),
                entry("$familyConflicts#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getFamilyConflicts() ? "✓" : "✗"),
                entry("$lowIncome#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getLowIncome() ? "✓" : "✗"),
                entry("$oldParent#", firstPhase.getFamilyRiskFactor().getGreenFamilyRiskFactor().getOldParent() ? "✓" : "✗"),
                entry("$pregnantWithKids#", firstPhase.getFamilyRiskFactor().getGreenFamilyRiskFactor().getPregnantWithKids() ? "✓" : "✗"),
                entry("$partialFamily#", firstPhase.getFamilyRiskFactor().getGreenFamilyRiskFactor().getPartialFamily() ? "✓" : "✗"),
                entry("$instituteParent#", firstPhase.getFamilyRiskFactor().getGreenFamilyRiskFactor().getInstituteParent() ? "✓" : "✗"),
                entry("$noSocialHelp#", firstPhase.getFamilyRiskFactor().getGreenFamilyRiskFactor().getNoSocialHelp() ? "✓" : "✗"),
                entry("$socialIsolation#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getSocialIsolation() ? "✓" : "✗"),
                entry("$littleAccessService#", firstPhase.getFamilyRiskFactor().getGreenFamilyRiskFactor().getLittleAccessService() ? "✓" : "✗"),
                entry("$discriminated#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getDiscriminated() ? "✓" : "✗"),
                entry("$unemployedMember#", firstPhase.getFamilyRiskFactor().getGreenFamilyRiskFactor().getUnemployedMember() ? "✓" : "✗"),
                entry("$hivParents#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getHivParents() ? "✓" : "✗"),
                entry("$invalidParent#", firstPhase.getFamilyRiskFactor().getGreenFamilyRiskFactor().getInvalidParent() ? "✓" : "✗"),
                entry("$warRefugeeFamily#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getWarRefugee() ? "✓" : "✗"),
                entry("$religiousParent#", firstPhase.getFamilyRiskFactor().getYellowFamilyRiskFactor().getReligiousParent() ? "✓" : "✗"),

                entry("$academicSuccess#", firstPhase.getIndividualSafeFactor().getAcademicSuccess() ? "✓" : "✗"),
                entry("$goodLifeSkills#", firstPhase.getIndividualSafeFactor().getGoodLifeSkills() ? "✓" : "✗"),
                entry("$active#", firstPhase.getIndividualSafeFactor().getActive() ? "✓" : "✗"),
                entry("$selfConfident#", firstPhase.getIndividualSafeFactor().getSelfConfident() ? "✓" : "✗"),

                entry("$familyRuleSet#", firstPhase.getFamilySafeFactor().getFamilyRuleSet() ? "✓" : "✗"),
                entry("$roleModel#", firstPhase.getFamilySafeFactor().getRoleModel() ? "✓" : "✗"),
                entry("supportingEnvironment#", firstPhase.getFamilySafeFactor().getSupportingEnvironment() ? "✓" : "✗"),
                entry("$safeBonding#", firstPhase.getFamilySafeFactor().getSafeBonding() ? "✓" : "✗"),
                entry("$caringParent#", firstPhase.getFamilySafeFactor().getCaringParent() ? "✓" : "✗"),
                entry("$stability#", firstPhase.getFamilySafeFactor().getStability() ? "✓" : "✗"),
                entry("$goodParentSkills#", firstPhase.getFamilySafeFactor().getGoodParentSkills() ? "✓" : "✗"),
                entry("$positivePractice#", firstPhase.getFamilySafeFactor().getPositivePractice() ? "✓" : "✗"),
                entry("$basicNeed#", firstPhase.getFamilySafeFactor().getBasicNeed() ? "✓" : "✗"),
                entry("$sustainableRelation#", firstPhase.getFamilySafeFactor().getSustainableRelation() ? "✓" : "✗"),

                entry("$economicStability#", firstPhase.getEnvironmentSafeFactor().getEconomicStability() ? "✓" : "✗"),
                entry("$employedParent#", firstPhase.getEnvironmentSafeFactor().getEmployedParent() ? "✓" : "✗"),
                entry("$educatedParent#", firstPhase.getEnvironmentSafeFactor().getEducatedParent() ? "✓" : "✗"),
                entry("$normalLivingCondition#", firstPhase.getEnvironmentSafeFactor().getNormalLivingCondition() ? "✓" : "✗"),
                entry("$socialHelp#", firstPhase.getEnvironmentSafeFactor().getSocialHelp() ? "✓" : "✗"),
                entry("$medicalAccess#", firstPhase.getEnvironmentSafeFactor().getMedicalAccess() ? "✓" : "✗"),
                entry("$resourceCoordination#", firstPhase.getEnvironmentSafeFactor().getResourceCoordination() ? "✓" : "✗"),

                entry("$safeSchool#", firstPhase.getSchoolSafeFactor().getSafeSchool() ? "✓" : "✗"),
                entry("$additionalClass#", firstPhase.getSchoolSafeFactor().getAdditionalClass() ? "✓" : "✗"),
                entry("$hasNpa#", firstPhase.getSchoolSafeFactor().getHasNpa() ? "✓" : "✗"),
                entry("$mentorship#", firstPhase.getSchoolSafeFactor().getMentorship() ? "✓" : "✗"),
                entry("$parentProgram#", firstPhase.getSchoolSafeFactor().getParentProgram() ? "✓" : "✗"),
                entry("$inclusive#", firstPhase.getSchoolSafeFactor().getInclusive() ? "✓" : "✗"),
                entry("$additionalCreativeClass#", firstPhase.getSchoolSafeFactor().getAdditionalCreativeClass() ? "✓" : "✗"),
                entry("$prophylactic#", firstPhase.getSchoolSafeFactor().getProphylactic() ? "✓" : "✗"),

                entry("$additionalComment#", firstPhase.getAdditionalComment())

                //additional comments loop
//                entry("$supportNotNeeded#", firstPhase.getActions().getSupportNotNeeded() ? "✓" : "✗"),
//                entry("$signContract#", firstPhase.getActions().getSignContract() ? "✓" : "✗"),
//                entry("$liveInDanger#", firstPhase.getActions().getLiveInDanger() ? "✓" : "✗"),
//                entry("$needSupport#", firstPhase.getActions().getNeedSupport() ? "✓" : "✗"),
//                entry("$caseManager#", firstPhase.getCaseManager()),
//                entry("$signDate#", firstPhase.getSignDate())
                ));


    }
}
