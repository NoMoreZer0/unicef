package swag.rest.nis_risk_app.helper;

import de.phip1611.Docx4JSRUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import swag.rest.nis_risk_app.entity.AboutFamily;
import swag.rest.nis_risk_app.entity.EducationSection;
import swag.rest.nis_risk_app.entity.EmotionalIntelligence;
import swag.rest.nis_risk_app.entity.FamilySection;
import swag.rest.nis_risk_app.entity.HealthSection;
import swag.rest.nis_risk_app.entity.IdentitySection;
import swag.rest.nis_risk_app.entity.SecondPhase;
import swag.rest.nis_risk_app.entity.SecuritySection;
import swag.rest.nis_risk_app.entity.SelfIndependence;
import swag.rest.nis_risk_app.util.HealthIssues;


@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SecondFormGenerator implements FormGenerator<SecondPhase>{
    Map map;
    public void generatePdf(WordprocessingMLPackage wordMLPackage, SecondPhase secondPhase) throws IOException {
        map = new HashMap();
        map.put("$nameOfStudent#", secondPhase.getStudentCase().getStudent().getNameOfStudent() == null ? "Не заполнено" : secondPhase.getStudentCase().getStudent().getNameOfStudent());
        map.put("$phoneNumber#", secondPhase.getStudentCase().getStudent().getPhoneNumber() == null ? "Не заполнено" : secondPhase.getStudentCase().getStudent().getPhoneNumber());
        map.put("$dateOfBirth#", secondPhase.getStudentCase().getStudent().getDateOfBirth() == null ? "Не заполнено" : secondPhase.getStudentCase().getStudent().getDateOfBirth());
        map.put("$studentCase.id#", secondPhase.getStudentCase().getId() == null ? "Не заполнено" : secondPhase.getStudentCase().getId()+"");
        map.put("$caseManager.fio#", secondPhase.getStudentCase().getCaseManager().getFio() == null ? "Не заполнено" : secondPhase.getStudentCase().getCaseManager().getFio());
        map.put("$caseManager.phoneNumber#", secondPhase.getStudentCase().getCaseManager().getPhoneNumber() == null ? "Не заполнено" : secondPhase.getStudentCase().getCaseManager().getPhoneNumber());

        modifyHealthSection(secondPhase.getHealthSection());
        modifyEducationSection(secondPhase.getEducationSection());
        modifyEmotionalIntelligence(secondPhase.getEmotionalIntelligence());
        modifyIdentitySection(secondPhase.getIdentitySection());
        modifyFamilySection(secondPhase.familySection());
        modifySelfIndependence(secondPhase.getSelfIndependence());
        modifySecuritySection(secondPhase.getSecuritySection());
        modifyAboutFamily(secondPhase.getAboutFamily());
        Docx4JSRUtil.searchAndReplace(wordMLPackage, map);
    }

    private void modifyHealthSection( HealthSection healthSection) {
        if (healthSection.getYellowHealthSection().getHealthIssues().equals(HealthIssues.NONE)) {
            map.put("$healthIssuesYes","☐");
            map.put("$healthIssuesNo", "☑");
            map.put("$psycho_disorder", "☐");
            map.put("$physical_disorder", "☐");
            map.put("$multiple_issues", "☐");
            map.put("$sensorial_disorder", "☐");
            map.put("$other", "☐");
        } else if (healthSection.getYellowHealthSection().getHealthIssues().equals(HealthIssues.PSYCHO_DISORDER)) {
            map.put("$healthIssuesYes","☑");
            map.put("$healthIssuesNo", "☐");
            map.put("$psycho_disorder", "☑");
            map.put("$physical_disorder", "☐");
            map.put("$multiple_issues", "☐");
            map.put("$sensorial_disorder", "☐");
            map.put("$other", "☐");
        } else if (healthSection.getYellowHealthSection().getHealthIssues().equals(HealthIssues.PHYSICAL_DISORDER)) {
            map.put("$healthIssuesYes","☑");
            map.put("$healthIssuesNo", "☐");
            map.put("$psycho_disorder", "☐");
            map.put("$physical_disorder", "☑");
            map.put("$multiple_issues", "☐");
            map.put("$sensorial_disorder", "☐");
            map.put("$other", "☐");
        } else if (healthSection.getYellowHealthSection().getHealthIssues().equals(HealthIssues.MULTIPLE_ISSUES)) {
            map.put("$healthIssuesYes","☑");
            map.put("$healthIssuesNo", "☐");
            map.put("$psycho_disorder", "☐");
            map.put("$physical_disorder", "☐");
            map.put("$multiple_issues", "☑");
            map.put("$sensorial_disorder", "☐");
            map.put("$other", "☐");
        } else if (healthSection.getYellowHealthSection().getHealthIssues().equals(HealthIssues.SENSORIAL_DISORDER)) {
            map.put("$healthIssuesYes","☑");
            map.put("$healthIssuesNo", "☐");
            map.put("$psycho_disorder", "☐");
            map.put("$physical_disorder", "☐");
            map.put("$multiple_issues", "☐");
            map.put("$sensorial_disorder", "☑");
            map.put("$other", "☐");
        } else {
            map.put("$healthIssuesYes","☑");
            map.put("$healthIssuesNo", "☐");
            map.put("$psycho_disorder", "☐");
            map.put("$physical_disorder", "☐");
            map.put("$multiple_issues", "☐");
            map.put("$sensorial_disorder", "☐");
            map.put("$other", "☑");
        }
        tickYesOrNo(healthSection.getYellowHealthSection().getHaveHealthIssues(), "haveHealthIssues");
        tickYesOrNo(healthSection.getYellowHealthSection().getNoChronicAttachment(), "noChronicAttachment");
        tickYesOrNo(healthSection.getGreenHealthSection().getNotVaccinated(), "notVaccinated");
        tickYesOrNo(healthSection.getYellowHealthSection().getNoPedSocMed(), "noPedSocMed");
        tickYesOrNo(healthSection.getYellowHealthSection().getNoPolyclinicAttachment(), "noPolyclinicAttachment");
        tickYesOrNo(healthSection.getYellowHealthSection().getNoRegularHealthCheck(), "noRegularHealthCheck");
        tickYesOrNo(healthSection.getRedHealthSection().getNotEatWell(), "notEatWell");
        tickYesOrNo(healthSection.getGreenHealthSection().getNotActive(), "notActive");
        tickYesOrNo(healthSection.getRedHealthSection().getNoGlasses(), "noGlasses");
        tickYesOrNo(healthSection.getRedHealthSection().getBadCoordination(), "badCoordination");
        tickYesOrNo(healthSection.getYellowHealthSection().getNoHeightWeightRatio(), "noHeightWeightRatio");
        tickYesOrNo(healthSection.getYellowHealthSection().getPhobia(), "phobia");
        tickYesOrNo(healthSection.getRedHealthSection().getBadHabits(), "badHabits");
        tickYesOrNo(healthSection.getRedHealthSection().getIncontinence(), "incontinence");
        tickYesOrNo(healthSection.getYellowHealthSection().getNoSleep(), "noSleep");
        tickYesOrNo(healthSection.getYellowHealthSection().getTrauma(), "trauma");
        tickYesOrNo(healthSection.getRedHealthSection().getSpeechIssues(), "speechIssues");
    }

    private void modifyEducationSection( EducationSection educationSection) {
        tickYesOrNo(educationSection.getRedEducationSection().getNoLikeAttend(), "noLikeAttend");
        tickYesOrNo(educationSection.getGreenEducationSection().getNoBelovedSubject(), "noBelovedSubject");
        tickYesOrNo(educationSection.getYellowEducationSection().getPartTime(), "partTime");
        tickYesOrNo(educationSection.getYellowEducationSection().getNoDiscipline(), "noDiscipline");
        tickYesOrNo(educationSection.getGreenEducationSection().getHaveSchoolFriend(), "haveSchoolFriend");
        tickYesOrNo(educationSection.getRedEducationSection().getSpecialNeed(), "specialNeed");
        tickYesOrNo(educationSection.getRedEducationSection().getStudyingTrouble(), "studyingTrouble");
        tickYesOrNo(educationSection.getRedEducationSection().getOftenMiss(), "oftenMiss");
        tickYesOrNo(educationSection.getYellowEducationSection().getNoConcentration(), "noConcentration");
        tickYesOrNo(educationSection.getGreenEducationSection().getNoParticipatedInClub(), "noParticipatedInClub");
        tickYesOrNo(educationSection.getYellowEducationSection().getNoKancellary(), "noKancellary");
        tickYesOrNo(educationSection.getYellowEducationSection().getNoComputer(), "noComputer");
        tickYesOrNo(educationSection.getYellowEducationSection().getNoUniform(), "noUniform");
        tickYesOrNo(educationSection.getYellowEducationSection().getTeacherConflict(), "teacherConflict");
        tickYesOrNo(educationSection.getYellowEducationSection().getNoHomeworkSpace(), "noHomeworkSpace");
        tickYesOrNo(educationSection.getYellowEducationSection().getNoMotivation(), "noMotivation");
    }

    private void modifyEmotionalIntelligence(EmotionalIntelligence emotionalIntelligence) {
        tickYesOrNo(emotionalIntelligence.getYellowEmotionalIntelligence().getEasilyUpset(), "easilyUpset");
        tickYesOrNo(emotionalIntelligence.getBloodyRedEmotionalIntelligence().getAnxiety(), "anxiety");
        tickYesOrNo(emotionalIntelligence.getYellowEmotionalIntelligence().getNoSchoolFriends(), "noSchoolFriends");
        tickYesOrNo(emotionalIntelligence.getBloodyRedEmotionalIntelligence().getDepression(), "depression");
        tickYesOrNo(emotionalIntelligence.getBloodyRedEmotionalIntelligence().getBullied(), "bullied");
        tickYesOrNo(emotionalIntelligence.getYellowEmotionalIntelligence().getOutsideHome(), "outsideHome");
        tickYesOrNo(emotionalIntelligence.getYellowEmotionalIntelligence().getEmotionalAlone(), "emotionalAlone");
        tickYesOrNo(emotionalIntelligence.getYellowEmotionalIntelligence().getSelfHarm(), "selfHarm");
        tickYesOrNo(emotionalIntelligence.getYellowEmotionalIntelligence().getLeftHome(), "leftHome");
        tickYesOrNo(emotionalIntelligence.getYellowEmotionalIntelligence().getZadira(), "zadira");
        tickYesOrNo(emotionalIntelligence.yellowEmotionalIntelligence().getRiskyBehaviour(), "riskyBehaviour");
        tickYesOrNo(emotionalIntelligence.getYellowEmotionalIntelligence().getWitnessConflict(), "witnessConflict");
        tickYesOrNo(emotionalIntelligence.yellowEmotionalIntelligence().getNoControlEmotion(), "noControlEmotion");
        tickYesOrNo(emotionalIntelligence.getBloodyRedEmotionalIntelligence().getSuicidalDream(), "suicidalDream");
        tickYesOrNo(emotionalIntelligence.getBloodyRedEmotionalIntelligence().getSuicidalAction(), "suicidalAction");
        tickYesOrNo(emotionalIntelligence.getYellowEmotionalIntelligence().getRobbery(), "robbery");
        tickYesOrNo(emotionalIntelligence.getYellowEmotionalIntelligence().getUchet(), "uchet");
        tickYesOrNo(emotionalIntelligence.getBloodyRedEmotionalIntelligence().getAggressor(), "aggressor");
        tickYesOrNo(emotionalIntelligence.getYellowEmotionalIntelligence().getNoGoodBad(), "noGoodBad");
        tickYesOrNo(emotionalIntelligence.getYellowEmotionalIntelligence().getNoSocietyNorms(), "noSocietyNorms");


    }

    private void modifyIdentitySection( IdentitySection identitySection) {
        tickYesOrNo(identitySection.getRedIdentitySection().getDiscrimination(), "discrimination");
        tickYesOrNo(identitySection.getYellowIdentitySection().getNoFamilyBelong(), "noFamilyBelong");
        tickYesOrNo(identitySection.getYellowIdentitySection().getCertainGenderProblem(), "certainGenderProblem");
        tickYesOrNo(identitySection.getRedIdentitySection().getGenderAcceptanceProblem(), "genderAcceptanceProblem");
        tickYesOrNo(identitySection.getYellowIdentitySection().getNoPositiveIndividual(), "noPositiveIndividual");
        tickYesOrNo(identitySection.getYellowIdentitySection().getNoDecisionMaker(), "noDecisionMaker");
        tickYesOrNo(identitySection.getGreenIdentitySection().getNoConfident(), "noConfident");
        tickYesOrNo(identitySection.getGreenIdentitySection().getNoHappyLook(), "noHappyLook");
        tickYesOrNo(identitySection.getGreenIdentitySection().getNoCulture(), "noCulture");
        tickYesOrNo(identitySection.getGreenIdentitySection().getNoIndependent(), "noIndependent");
        tickYesOrNo(identitySection.getYellowIdentitySection().getNoHygiene(), "noHygiene");
    }

    private void modifyFamilySection( FamilySection familySection) {
        tickYesOrNo(familySection.getYellowFamilySection().getNoPositiveWithParent(), "noPositiveWithParent");
        tickYesOrNo(familySection.getYellowFamilySection().getNoAdultDepend(), "noAdultDepend");
        tickYesOrNo(familySection.getBloodyRedFamilySection().getAbusiveBehaviorOfParents(), "abusiveBehaviorOfParents");
        tickYesOrNo(familySection.getYellowFamilySection().getNoBondingParentKid(), "noBondingParentKid");
        tickYesOrNo(familySection.getYellowFamilySection().getNoLikeFamilyMember(), "noLikeFamilyMember");
        tickYesOrNo(familySection.getYellowFamilySection().getNoFriend(), "noFriend");
        tickYesOrNo(familySection.getYellowFamilySection().getNoParentSkill(), "noParentSkill");
        tickYesOrNo(familySection.getYellowFamilySection().getTakeParentRole(), "takeParentRole");
        tickYesOrNo(familySection.getGreenFamilySection().getParentsChanged(), "parentsChanged");
        tickYesOrNo(familySection.getRedFamilySection().getConstantlySeeingConflicts(), "constantlySeeingConflicts");
        tickYesOrNo(familySection.getGreenFamilySection().getNoSpareTime(), "noSpareTime");
        tickYesOrNo(familySection.getYellowFamilySection().getFarAway(), "farAway");
        tickYesOrNo(familySection.getBloodyRedFamilySection().getNotSecuredFromSexualAffection(), "notSecuredFromSexualAffection");
        tickYesOrNo(familySection.getYellowFamilySection().getProblemParentKid(), "problemParentKid");
        tickYesOrNo(familySection.getYellowFamilySection().getChronic(), "chronic");
        tickYesOrNo(familySection.getYellowFamilySection().getSudimost(), "sudimost");
        tickYesOrNo(familySection.getYellowFamilySection().getTraumaPast(), "traumaPast");
    }

    private void modifySelfIndependence( SelfIndependence selfIndependence) {
        tickYesOrNo(selfIndependence.getGreenSelfIndependence().getNoPoowrenie(),"noPoowrenie");
        tickYesOrNo(selfIndependence.getGreenSelfIndependence().getNoPracticalSkill(),"noPracticalSkill");
        tickYesOrNo(selfIndependence.getGreenSelfIndependence().getNoMoneySkill(), "noMoneySkill");
        tickYesOrNo(selfIndependence.getYellowSelfIndependence().getNotAbleToCareHimself(), "notAbleToCareHimself");
    }

    private void modifySecuritySection( SecuritySection securitySection) {
        tickYesOrNo(securitySection.getRedSecuritySection().getParentNotAbleToProvideBasicThing(), "parentNotAbleToProvideBasicThing");
        tickYesOrNo(securitySection.getGreenSecuritySection().getNoSchedule(), "noSchedule");
        tickYesOrNo(securitySection.getYellowSecuritySection().getHaveEducationEnv(), "haveEducationEnv");
        tickYesOrNo(securitySection.getRedSecuritySection().getParentsNotGoesToDoctorWhenNeeded(), "parentsNotGoesToDoctorWhenNeeded");
        tickYesOrNo(securitySection.getGreenSecuritySection().getNoPraise(), "noPraise");
        tickYesOrNo(securitySection.getYellowSecuritySection().getFrequentSchoolChange(), "frequentSchoolChange");
        tickYesOrNo(securitySection.getGreenSecuritySection().getNoKnowProblem(), "noKnowProblem");
        tickYesOrNo(securitySection.getYellowSecuritySection().getParentNoInterestWhere(), "parentNoInterestWhere");
        tickYesOrNo(securitySection.getYellowSecuritySection().getNoLawFamily(), "noLawFamily");
    }


    private void modifyAboutFamily( AboutFamily aboutFamily) {
        tickYesOrNo(aboutFamily.getGreenAboutFamily().getNoHaveOwnHouse(), "noHaveOwnHouse");
        tickYesOrNo(aboutFamily.getYellowAboutFamily().getAvaryHome(), "avaryHome");
        tickYesOrNo(aboutFamily.getYellowAboutFamily().getCurrentHomeBad(), "currentHomeBad");
        tickYesOrNo(aboutFamily.getYellowAboutFamily().getParentUnemployed(), "parentUnemployed");
        tickYesOrNo(aboutFamily.getYellowAboutFamily().getFamilyNoTakeNeededAllowance(), "familyNoTakeNeededAllowance");
        tickYesOrNo(aboutFamily.getYellowAboutFamily().getHaveMaterialIssue(), "haveMaterialIssue");
    }

    private void tickYesOrNo(Boolean isYes, String text) {
        if (isYes) {
            map.put("$"+text+"Yes#","☑");
            map.put("$"+text+"No#", "☐");
        } else {
            map.put("$"+text+"Yes#","☐");
            map.put("$"+text+"No#", "☑");
        }
    }
}
