package com.company.unicef.screen.firstform;

import io.jmix.core.Messages;
import io.jmix.ui.component.*;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.unicef.entity.FirstForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@UiController("FirstForm.edit")
@UiDescriptor("first-form-edit.xml")
@EditedEntityContainer("firstFormDc")
public class FirstFormEdit extends StandardEditor<FirstForm> {
    private static final Logger log = LoggerFactory.getLogger(FirstFormEdit.class);
    @Inject
    private TextField<String> riskLevelField;
    @Inject
    private TextArea<String> descriptionField;
    @Inject
    private Messages messages;
    @Inject
    private Form finalCalculationTable;
    @Inject
    private Form finalCalculationSteps;
    @Inject
    private CheckBox checkBoxNextStep1;
    @Inject
    private CheckBox checkBoxNextStep6;
    @Inject
    private CheckBox checkBoxNextStep5;
    @Inject
    private CheckBox checkBoxNextStep4;
    @Inject
    private CheckBox checkBoxNextStep3;
    @Inject
    private CheckBox checkBoxNextStep2;
    @Inject
    private InstanceContainer<FirstForm> firstFormDc;
    @Autowired
    private CheckBox checkboxWeakSkillsField;
    @Autowired
    private CheckBox checkboxSuicidalField;
    @Autowired
    private CheckBox checkboxStressTraumField;
    @Autowired
    private CheckBox checkboxSchoolSafeEnvField;
    @Autowired
    private CheckBox checkboxSchoolProfilactationField;
    @Autowired
    private CheckBox checkboxSchoolParentsCommField;
    @Autowired
    private CheckBox checkboxSchoolNPAField;
    @Autowired
    private CheckBox checkboxSchoolMentorField;
    @Autowired
    private CheckBox checkboxSchoolInclusiveField;
    @Autowired
    private CheckBox checkboxSchoolAddField;
    @Autowired
    private CheckBox checkboxSchoolAddCreativeField;
    @Autowired
    private CheckBox checkboxRiskSuicidalField;
    @Autowired
    private CheckBox checkboxRiskActionField;
    @Autowired
    private CheckBox checkboxReligiousRadicalismField;
    @Autowired
    private CheckBox checkboxPsychoField;
    @Autowired
    private CheckBox checkboxPsixField;
    @Autowired
    private CheckBox checkboxParentsZonaField;
    @Autowired
    private CheckBox checkboxParentsWorkMigrationField;
    @Autowired
    private CheckBox checkboxParentsWeakSkillsField;
    @Autowired
    private CheckBox checkboxParentsViolenceField;
    @Autowired
    private CheckBox checkboxParentsSingleFamilyField;
    @Autowired
    private CheckBox checkboxParentsReligiousRadicalizationField;
    @Autowired
    private CheckBox checkboxParentsPsychoField;
    @Autowired
    private CheckBox checkboxParentsPoorFamilyField;
    @Autowired
    private CheckBox checkboxParentsOrphangeField;
    @Autowired
    private CheckBox checkboxParentsNoWorkField;
    @Autowired
    private CheckBox checkboxParentsNoTransportField;
    @Autowired
    private CheckBox checkboxParentsNoSocialHelpField;
    @Autowired
    private CheckBox checkboxParentsNoServiceAccessField;
    @Autowired
    private CheckBox checkboxParentsNoMoneyField;
    @Autowired
    private CheckBox checkboxParentsNoHomeField;
    @Autowired
    private CheckBox checkboxParentsNoDrugsField;
    @Autowired
    private CheckBox checkboxParentsMotherPregnantField;
    @Autowired
    private CheckBox checkboxParentsLowEducationField;
    @Autowired
    private CheckBox checkboxParentsIsolation;
    @Autowired
    private CheckBox checkboxParentsHIVField;
    @Autowired
    private CheckBox checkboxParentsFromWarField;
    @Autowired
    private CheckBox checkboxParentsFamilyConflictField;
    @Autowired
    private CheckBox checkboxParentsEldersField;
    @Autowired
    private CheckBox checkboxParentsDivorceField;
    @Autowired
    private CheckBox checkboxParentsDiscriminationField;
    @Autowired
    private CheckBox checkboxParentsDisabledField;
    @Autowired
    private CheckBox checkboxParentsBomzhField;
    @Autowired
    private CheckBox checkboxParentsBadRelationshipField;
    @Autowired
    private CheckBox checkboxParentsAlcoField;
    @Autowired
    private CheckBox checkboxOutsideFamilyField;
    @Autowired
    private TextField<String> checkboxOthers8Field;
    @Autowired
    private TextField<String> checkboxOthers7Field;
    @Autowired
    private TextField<String> checkboxOthers6Field;
    @Autowired
    private TextField<String> checkboxOthers5Field;
    @Autowired
    private TextField<String> checkboxOthers4Field;
    @Autowired
    private TextField<String> checkboxOthers3Field;
    @Autowired
    private TextField<String> checkboxOthers2Field;
    @Autowired
    private TextField<String> checkboxOthers1Field;
    @Autowired
    private CheckBox checkboxOrphangeField;
    @Autowired
    private CheckBox checkboxNoSeasonClothesField;
    @Autowired
    private CheckBox checkboxNoFoodField;
    @Autowired
    private CheckBox checkboxNoFamilyControlField;
    @Autowired
    private CheckBox checkboxNoEducationMotivationField;
    @Autowired
    private CheckBox checkboxNoClothesForSchoolField;
    @Autowired
    private CheckBox checkboxNoCareOfParentsField;
    @Autowired
    private CheckBox checkboxNoAttendanceField;
    @Autowired
    private CheckBox checkboxNoAdditionalConsultationField;
    @Autowired
    private CheckBox checkboxLegalProblemsField;
    @Autowired
    private CheckBox checkboxLargeFamilyField;
    @Autowired
    private CheckBox checkboxIndFactorSelfConfidenceField;
    @Autowired
    private CheckBox checkboxIndFactorOwnProblemField;
    @Autowired
    private CheckBox checkboxIndFactorGoodProblemSolvingField;
    @Autowired
    private CheckBox checkboxIndFactorAcademicField;
    @Autowired
    private CheckBox checkboxHIVChildField;
    @Autowired
    private CheckBox checkboxGriefOfLossField;
    @Autowired
    private CheckBox checkboxFrequestAbsenceField;
    @Autowired
    private CheckBox checkboxFamilyFactorStableRelationshipField;
    @Autowired
    private CheckBox checkboxFamilyFactorStableField;
    @Autowired
    private CheckBox checkboxFamilyFactorSocialMediaField;
    @Autowired
    private CheckBox checkboxFamilyFactorSafeField;
    @Autowired
    private CheckBox checkboxFamilyFactorRulesField;
    @Autowired
    private CheckBox checkboxFamilyFactorPositiveField;
    @Autowired
    private CheckBox checkboxFamilyFactorGoodSkillsField;
    @Autowired
    private CheckBox checkboxFamilyFactorCaringField;
    @Autowired
    private CheckBox checkboxFamilyFactorCaringAdultsField;
    @Autowired
    private CheckBox checkboxFamilyFactorBaseHelpField;
    @Autowired
    private CheckBox checkboxExplotationField;
    @Autowired
    private CheckBox checkboxEnvSocialHelpField;
    @Autowired
    private CheckBox checkboxEnvParentsEmpField;
    @Autowired
    private CheckBox checkboxEnvParentsEduField;
    @Autowired
    private CheckBox checkboxEnvMedicalAdultsAndKindsField;
    @Autowired
    private CheckBox checkboxEnvLivingCondField;
    @Autowired
    private CheckBox checkboxEnvEconomStableField;
    @Autowired
    private CheckBox checkboxEnvCoordinationServicesField;
    @Autowired
    private CheckBox checkboxEarlyPregnancyField;
    @Autowired
    private CheckBox checkboxDomesticViolenceField;
    @Autowired
    private CheckBox checkboxDisabledField;
    @Autowired
    private CheckBox checkboxDaunField;
    @Autowired
    private CheckBox checkboxConsultationAbsenceField;
    @Autowired
    private CheckBox checkboxConflictZonesField;
    @Autowired
    private CheckBox checkboxChildTeacherConflictField;
    @Autowired
    private CheckBox checkboxChildParentsConflictField;
    @Autowired
    private CheckBox checkboxChildLabourField;
    @Autowired
    private CheckBox checkboxChildAtRiskField;
    @Autowired
    private CheckBox checkboxChildAbuseField;
    @Autowired
    private CheckBox checkboxBullingField;
    @Autowired
    private CheckBox checkboxBadGradesField;
    @Autowired
    private CheckBox checkboxBadConsultationField;
    @Autowired
    private CheckBox checkboxAbsenceByHealthField;

    @Autowired
    private TextField textFieldNextStep;
    private double sumMean = 0;
    private List<CheckBox> socialMedicalFactorsList = new ArrayList<>();
    private HashMap<CheckBox, Double> socialMedicalFactorsMap = new HashMap<>();
    private List<CheckBox> individualFactorsList = new ArrayList<>();
    private HashMap<CheckBox, Double> individualFactorsMap = new HashMap<>();
    private ArrayList<CheckBox> familyFactorsList = new ArrayList<>();
    private HashMap<CheckBox, Double> familyFactorsMap = new HashMap<>();
    private ArrayList<CheckBox> academicFactorsList = new ArrayList<>();
    private HashMap<CheckBox, Double> academicFactorsMap = new HashMap<>();
    private static String MESSAGE_PACK = "com.company.unicef.entity";
    @Subscribe("calculateRiskBtn")
    public void onCalculateRiskBtnClick(Button.ClickEvent event) {
        upd();
        calcSocialMedicalFactors();
        calcIndividualFactors();
        calcFamilyFactors();
        calcAcademicFactors();
        double B = sumMean / 4.0;
        if (isDefenseFactorChecked()) {
            B = 1.0;
        }
        String riskLevelMsg = "", descMsg = "";
        finalCalculationSteps.setVisible(true);
        textFieldNextStep.setVisible(true);
        textFieldNextStep.setCaption(messages.getMessage(MESSAGE_PACK, "FirstForm.textFieldNextStepCaption"));
        if (0.9 <= B && B <= 1.1) {
            riskLevelMsg = messages.getMessage(MESSAGE_PACK, "FirstForm.riskLevelFieldHigh");
            descMsg = messages.getMessage(MESSAGE_PACK, "FirstForm.descriptionFieldHigh");
            checkBoxNextStep1.setCaption(messages.getMessage(MESSAGE_PACK, "FirstForm.checkBoxNextStep1High"));
            checkBoxNextStep1.setVisible(true);
            checkBoxNextStep2.setCaption(messages.getMessage(MESSAGE_PACK, "FirstForm.checkBoxNextStep2High"));
            checkBoxNextStep2.setVisible(true);
            checkBoxNextStep3.setCaption(messages.getMessage(MESSAGE_PACK, "FirstForm.checkBoxNextStep3High"));
            checkBoxNextStep3.setVisible(true);
            checkBoxNextStep4.setCaption(messages.getMessage(MESSAGE_PACK, "FirstForm.checkBoxNextStep4High"));
            checkBoxNextStep4.setVisible(true);
            checkBoxNextStep5.setCaption(messages.getMessage(MESSAGE_PACK, "FirstForm.checkBoxNextStep5High"));
            checkBoxNextStep5.setVisible(true);
            checkBoxNextStep6.setCaption(messages.getMessage(MESSAGE_PACK, "FirstForm.checkBoxNextStep6High"));
            checkBoxNextStep6.setVisible(true);
        }
        else if (0.71 <= B && B <= 0.89) {
            riskLevelMsg = messages.getMessage(MESSAGE_PACK, "FirstForm.riskLevelFieldMedium");
            descMsg = messages.getMessage(MESSAGE_PACK, "FirstForm.descriptionFieldMedium");
            checkBoxNextStep1.setCaption(messages.getMessage(MESSAGE_PACK, "checkBoxNextStep1Medium"));
            checkBoxNextStep1.setVisible(true);
            checkBoxNextStep2.setCaption(messages.getMessage(MESSAGE_PACK, "checkBoxNextStep2Medium"));
            checkBoxNextStep2.setVisible(true);
        }
        else {
            riskLevelMsg = messages.getMessage(MESSAGE_PACK, "FirstForm.riskLevelFieldLow");
            descMsg = messages.getMessage(MESSAGE_PACK, "FirstForm.descriptionFieldLow");
            checkBoxNextStep1.setCaption(messages.getMessage(MESSAGE_PACK, "FirstForm.checkBoxNextStep1Low"));
            checkBoxNextStep1.setVisible(true);
            checkBoxNextStep2.setCaption(messages.getMessage(MESSAGE_PACK, "FirstForm.checkBoxNextStep2Low"));
            checkBoxNextStep2.setVisible(true);
        }
        riskLevelField.setValue(riskLevelMsg);
        descriptionField.setValue(descMsg);
        finalCalculationTable.setVisible(true);
    }

    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
        double B = sumMean / 4.0;
        if (isDefenseFactorChecked()) {
            B = 1.0;
        }
        FirstForm firstForm = firstFormDc.getItem();
        if (0.9 <= B && B <= 1.1) {
            firstForm.setCheckboxFinalRiskLevelHigh(true);
            if (checkBoxNextStep1.isChecked()) firstForm.setCheckboxFinalRiskLevelHighStep1(true);
            if (checkBoxNextStep2.isChecked()) firstForm.setCheckboxFinalRiskLevelHighStep2(true);
            if (checkBoxNextStep3.isChecked()) firstForm.setCheckboxFinalRiskLevelHighStep3(true);
            if (checkBoxNextStep4.isChecked()) firstForm.setCheckboxFinalRiskLevelHighStep4(true);
            if (checkBoxNextStep5.isChecked()) firstForm.setCheckboxFinalRiskLevelHighStep5(true);
            if (checkBoxNextStep6.isChecked()) firstForm.setCheckboxFinalRiskLevelHighStep6(true);
            firstForm.setCheckboxFinalRiskLevelHighOthers(textFieldNextStep.getRawValue());
        }
        else if (0.71 <= B && B <= 0.89) {
            firstForm.setCheckboxFinalRiskLevelMedium(true);
            if (checkBoxNextStep1.isChecked()) firstForm.setCheckboxFinalRiskLevelMediumStep1(true);
            if (checkBoxNextStep2.isChecked()) firstForm.setCheckboxFinalRiskLevelMediumStep2(true);
            firstForm.setCheckboxFinalRiskLevelMediumOthers(textFieldNextStep.getRawValue());
        }
        else {
            firstForm.setCheckboxFinalRiskLevelLow(true);
            if (checkBoxNextStep1.isChecked()) firstForm.setCheckboxFinalRiskLevelLowStep1(true);
            if (checkBoxNextStep2.isChecked()) firstForm.setCheckboxFinalRiskLevelLowStep2(true);
            firstForm.setCheckboxFinalRiskLevelLowOthers(textFieldNextStep.getRawValue());
        }
        firstFormDc.setItem(firstForm);
    }

    private boolean isDefenseFactorChecked() {
        boolean ans = checkboxIndFactorAcademicField.isChecked();
        if (checkboxFamilyFactorRulesField.isChecked()) ans = true;
        if (checkboxIndFactorGoodProblemSolvingField.isChecked()) ans = true;
        if (checkboxFamilyFactorCaringAdultsField.isChecked()) ans = true;
        if (checkboxIndFactorOwnProblemField.isChecked()) ans = true;
        if (checkboxFamilyFactorSocialMediaField.isChecked()) ans = true;
        if (checkboxIndFactorSelfConfidenceField.isChecked()) ans = true;
        if (checkboxFamilyFactorSafeField.isChecked()) ans = true;
        if (checkboxEnvEconomStableField.isChecked()) ans = true;
        if (checkboxFamilyFactorCaringField.isChecked()) ans = true;
        if (checkboxEnvParentsEmpField.isChecked()) ans = true;
        if (checkboxEnvParentsEmpField.isChecked()) ans = true;
        if (checkboxEnvParentsEduField.isChecked()) ans = true;
        if (checkboxFamilyFactorGoodSkillsField.isChecked()) ans = true;
        if (checkboxEnvLivingCondField.isChecked()) ans = true;
        if (checkboxFamilyFactorPositiveField.isChecked()) ans = true;
        if (checkboxEnvSocialHelpField.isChecked()) ans = true;
        if (checkboxFamilyFactorBaseHelpField.isChecked()) ans = true;
        if (checkboxEnvMedicalAdultsAndKindsField.isChecked()) ans = true;
        if (checkboxFamilyFactorStableRelationshipField.isChecked()) ans = true;
        if (checkboxEnvCoordinationServicesField.isChecked()) ans = true;
        if (checkboxSchoolSafeEnvField.isChecked()) ans = true;
        if (checkboxSchoolParentsCommField.isChecked()) ans = true;
        if (checkboxSchoolAddField.isChecked()) ans = true;
        if (checkboxSchoolInclusiveField.isChecked()) ans = true;
        if (checkboxSchoolNPAField.isChecked()) ans = true;
        if (checkboxSchoolAddCreativeField.isChecked()) ans = true;
        if (checkboxSchoolMentorField.isChecked()) ans = true;
        if (checkboxSchoolProfilactationField.isChecked()) ans = true;
        return ans;
    }
    private void upd() {
        finalCalculationSteps.setVisible(false);
        finalCalculationTable.setVisible(false);
        checkBoxNextStep1.setVisible(false);
        checkBoxNextStep2.setVisible(false);
        checkBoxNextStep3.setVisible(false);
        checkBoxNextStep4.setVisible(false);
        checkBoxNextStep5.setVisible(false);
        checkBoxNextStep6.setVisible(false);
        textFieldNextStep.setVisible(false);
    }
    private void calcFactorsMean(List<CheckBox> list, HashMap<CheckBox, Double> map) {
        double curMean, sumCoef = 0, sumNum = 0;
        for (int i = 0; i < list.size(); ++i) {
            double num = 1.0 * (i + 1), coef = map.get(list.get(i));
            sumCoef += (num + coef);
            sumNum += num;
        }
        curMean = (sumCoef / sumNum);
        sumMean += curMean;
    }
    private void calcSocialMedicalFactors() {
        initSocialMedicalFactors();
        calcFactorsMean(socialMedicalFactorsList, socialMedicalFactorsMap);
    }
    private void calcIndividualFactors() {
        initIndividualFactors();
        calcFactorsMean(individualFactorsList, individualFactorsMap);
    }

    private void calcFamilyFactors() {
        initFamilyFactors();
        calcFactorsMean(familyFactorsList, familyFactorsMap);
    }
    private void calcAcademicFactors() {
        initAcademicFactors();
        calcFactorsMean(academicFactorsList, academicFactorsMap);
    }
    private void initSocialMedicalFactors() {
        socialMedicalFactorsList.add(checkboxNoCareOfParentsField);
        socialMedicalFactorsMap.put(checkboxNoCareOfParentsField, 0.92);
        socialMedicalFactorsList.add(checkboxChildAtRiskField);
        socialMedicalFactorsMap.put(checkboxChildAtRiskField, 0.84);
        socialMedicalFactorsList.add(checkboxChildLabourField);
        socialMedicalFactorsMap.put(checkboxChildLabourField, 0.90);
        socialMedicalFactorsList.add(checkboxDisabledField);
        socialMedicalFactorsMap.put(checkboxDisabledField, 0.72);
        socialMedicalFactorsList.add(checkboxEarlyPregnancyField);
        socialMedicalFactorsMap.put(checkboxEarlyPregnancyField, 0.88);
        socialMedicalFactorsList.add(checkboxHIVChildField);
        socialMedicalFactorsMap.put(checkboxHIVChildField, 0.76);
        socialMedicalFactorsList.add(checkboxDomesticViolenceField);
        socialMedicalFactorsMap.put(checkboxDomesticViolenceField, 0.94);
        socialMedicalFactorsList.add(checkboxChildAbuseField);
        socialMedicalFactorsMap.put(checkboxChildAbuseField, 0.88);
        socialMedicalFactorsList.add(checkboxPsixField);
        socialMedicalFactorsMap.put(checkboxPsixField, 0.88);
        socialMedicalFactorsList.add(checkboxExplotationField);
        socialMedicalFactorsMap.put(checkboxExplotationField, 0.92);
        socialMedicalFactorsList.add(checkboxReligiousRadicalismField);
        socialMedicalFactorsMap.put(checkboxReligiousRadicalismField, 0.88);
        socialMedicalFactorsList.add(checkboxConflictZonesField);
        socialMedicalFactorsMap.put(checkboxConflictZonesField, 0.84);
        socialMedicalFactorsList.add(checkboxOrphangeField);
        socialMedicalFactorsMap.put(checkboxOrphangeField, 0.80);
        socialMedicalFactorsList.add(checkboxNoFoodField);
        socialMedicalFactorsMap.put(checkboxNoFoodField, 0.72);
        socialMedicalFactorsList.add(checkboxNoSeasonClothesField);
        socialMedicalFactorsMap.put(checkboxNoSeasonClothesField, 0.56);
        socialMedicalFactorsList.add(checkboxLegalProblemsField);
        socialMedicalFactorsMap.put(checkboxLegalProblemsField, 0.60);
        socialMedicalFactorsList.add(checkboxOutsideFamilyField);
        socialMedicalFactorsMap.put(checkboxOutsideFamilyField, 0.70);
    }

    private void initIndividualFactors() {
        individualFactorsList.add(checkboxRiskActionField);
        individualFactorsMap.put(checkboxRiskActionField, 0.96);
        individualFactorsList.add(checkboxSuicidalField);
        individualFactorsMap.put(checkboxSuicidalField, 0.84);
        individualFactorsList.add(checkboxRiskSuicidalField);
        individualFactorsMap.put(checkboxRiskSuicidalField, 0.94);
        individualFactorsList.add(checkboxGriefOfLossField);
        individualFactorsMap.put(checkboxGriefOfLossField, 0.76);
        individualFactorsList.add(checkboxStressTraumField);
        individualFactorsMap.put(checkboxStressTraumField, 0.76);
        individualFactorsList.add(checkboxDaunField);
        individualFactorsMap.put(checkboxDaunField, 0.78);
        individualFactorsList.add(checkboxWeakSkillsField);
        individualFactorsMap.put(checkboxWeakSkillsField, 0.64);
        individualFactorsList.add(checkboxPsychoField);
        individualFactorsMap.put(checkboxPsychoField, 0.74);
        individualFactorsList.add(checkboxBullingField);
        individualFactorsMap.put(checkboxBullingField, 0.88);
    }

    private void initFamilyFactors() {
        familyFactorsList.add(checkboxLargeFamilyField);
        familyFactorsMap.put(checkboxLargeFamilyField, 0.54);
        familyFactorsList.add(checkboxParentsSingleFamilyField);
        familyFactorsMap.put(checkboxParentsSingleFamilyField, 0.56);
        familyFactorsList.add(checkboxParentsAlcoField);
        familyFactorsMap.put(checkboxParentsAlcoField, 0.86);
        familyFactorsList.add(checkboxParentsWorkMigrationField);
        familyFactorsMap.put(checkboxParentsWorkMigrationField, 0.66);
        familyFactorsList.add(checkboxParentsBomzhField);
        familyFactorsMap.put(checkboxParentsBomzhField, 0.76);
        familyFactorsList.add(checkboxParentsFromWarField);
        familyFactorsMap.put(checkboxParentsFromWarField, 0.80);
        familyFactorsList.add(checkboxParentsZonaField);
        familyFactorsMap.put(checkboxParentsZonaField, 0.78);
        familyFactorsList.add(checkboxParentsMotherPregnantField);
        familyFactorsMap.put(checkboxParentsMotherPregnantField, 0.52);
        familyFactorsList.add(checkboxParentsPoorFamilyField);
        familyFactorsMap.put(checkboxParentsPoorFamilyField, 0.72);
        familyFactorsList.add(checkboxParentsDisabledField);
        familyFactorsMap.put(checkboxParentsDisabledField, 0.68);
        familyFactorsList.add(checkboxParentsEldersField);
        familyFactorsMap.put(checkboxParentsEldersField, 0.54);
        familyFactorsList.add(checkboxParentsReligiousRadicalizationField);
        familyFactorsMap.put(checkboxParentsReligiousRadicalizationField, 0.76);
        familyFactorsList.add(checkboxParentsLowEducationField);
        familyFactorsMap.put(checkboxParentsLowEducationField, 0.56);
        familyFactorsList.add(checkboxParentsWeakSkillsField);
        familyFactorsMap.put(checkboxParentsWeakSkillsField, 0.66);
        familyFactorsList.add(checkboxParentsBadRelationshipField);
        familyFactorsMap.put(checkboxParentsBadRelationshipField, 0.78);
        familyFactorsList.add(checkboxParentsDivorceField);
        familyFactorsMap.put(checkboxParentsDivorceField, 0.80);
        familyFactorsList.add(checkboxParentsFamilyConflictField);
        familyFactorsMap.put(checkboxParentsFamilyConflictField, 0.78);
        familyFactorsList.add(checkboxParentsOrphangeField);
        familyFactorsMap.put(checkboxParentsOrphangeField, 0.64);
        familyFactorsList.add(checkboxParentsNoHomeField);
        familyFactorsMap.put(checkboxParentsNoHomeField, 0.80);
        familyFactorsList.add(checkboxParentsNoDrugsField);
        familyFactorsMap.put(checkboxParentsNoDrugsField, 0.72);
        familyFactorsList.add(checkboxParentsNoTransportField);
        familyFactorsMap.put(checkboxParentsNoTransportField, 0.64);
        familyFactorsList.add(checkboxParentsNoMoneyField);
        familyFactorsMap.put(checkboxParentsNoMoneyField, 0.60);
        familyFactorsList.add(checkboxParentsNoSocialHelpField);
        familyFactorsMap.put(checkboxParentsNoSocialHelpField, 0.64);
        familyFactorsList.add(checkboxParentsIsolation);
        familyFactorsMap.put(checkboxParentsIsolation, 0.72);
        familyFactorsList.add(checkboxParentsNoServiceAccessField);
        familyFactorsMap.put(checkboxParentsNoServiceAccessField, 0.58);
        familyFactorsList.add(checkboxParentsDiscriminationField);
        familyFactorsMap.put(checkboxParentsDiscriminationField, 0.78);
        familyFactorsList.add(checkboxParentsNoWorkField);
        familyFactorsMap.put(checkboxParentsNoWorkField, 0.60);
        familyFactorsList.add(checkboxParentsViolenceField);
        familyFactorsMap.put(checkboxParentsViolenceField, 0.82);
        familyFactorsList.add(checkboxParentsPsychoField);
        familyFactorsMap.put(checkboxParentsPsychoField, 0.86);
        familyFactorsList.add(checkboxHIVChildField);
        familyFactorsMap.put(checkboxHIVChildField, 0.74);
    }
    private void initAcademicFactors() {
        academicFactorsList.add(checkboxFrequestAbsenceField);
        academicFactorsMap.put(checkboxFrequestAbsenceField, 0.82);
        academicFactorsList.add(checkboxAbsenceByHealthField);
        academicFactorsMap.put(checkboxAbsenceByHealthField, 0.70);
        academicFactorsList.add(checkboxBadGradesField);
        academicFactorsMap.put(checkboxBadGradesField, 0.76);
        academicFactorsList.add(checkboxNoEducationMotivationField);
        academicFactorsMap.put(checkboxNoEducationMotivationField, 0.72);
        academicFactorsList.add(checkboxNoClothesForSchoolField);
        academicFactorsMap.put(checkboxNoClothesForSchoolField, 0.68);
        academicFactorsList.add(checkboxNoFamilyControlField);
        academicFactorsMap.put(checkboxNoFamilyControlField, 0.76);
        academicFactorsList.add(checkboxNoAdditionalConsultationField);
        academicFactorsMap.put(checkboxNoAdditionalConsultationField, 0.64);
        academicFactorsList.add(checkboxConsultationAbsenceField);
        academicFactorsMap.put(checkboxConsultationAbsenceField, 0.64);
        academicFactorsList.add(checkboxBadConsultationField);
        academicFactorsMap.put(checkboxBadConsultationField, 0.64);
        academicFactorsList.add(checkboxChildTeacherConflictField);
        academicFactorsMap.put(checkboxChildTeacherConflictField, 0.78);
        academicFactorsList.add(checkboxChildParentsConflictField);
        academicFactorsMap.put(checkboxChildParentsConflictField, 0.74);
    }
}