package com.company.unicef.screen.secondform;

import com.company.unicef.app.PivotTableMapper;
import com.company.unicef.entity.HealthChronicalOption;
import com.company.unicef.entity.PivotTableCheckBoxes;
import com.company.unicef.entity.SecondForm;
import com.company.unicef.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.component.*;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.screen.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@UiController("SecondForm.edit")
@UiDescriptor("second-form-edit.xml")
@EditedEntityContainer("secondFormDc")
public class SecondFormEdit extends StandardEditor<SecondForm> {
    private static final Logger log = LoggerFactory.getLogger(
            SecondFormEdit.class
    );
    @Autowired
    private CheckBox healthChronicalField;
    @Autowired
    private CheckBox healthNoRegisteredField;
    @Autowired
    private CheckBox healthNoVaccinationField;
    @Autowired
    private CheckBox healthDisabledNoHelpField;
    @Autowired
    private CheckBox healthNoHospitalField;
    private List<CheckBox> healthCheckBoxesLow = new ArrayList<>();
    private List<CheckBox> healthCheckBoxesMedium = new ArrayList<>();
    private List<CheckBox> healthCheckBoxesHigh = new ArrayList<>();
    @Autowired
    private CheckBox healthNoTestingField;
    @Autowired
    private CheckBox healthNoFoodField;
    @Autowired
    private CheckBox healthNoSportField;
    @Autowired
    private CheckBox healthNoEquipmentField;
    @Autowired
    private CheckBox healthNoCoordinationField;
    @Autowired
    private CheckBox healthBadWeightOrHeightField;
    @Autowired
    private CheckBox healthFobiaField;
    @Autowired
    private CheckBox healthBadHabitsField;
    @Autowired
    private CheckBox healthWetsBedField;
    @Autowired
    private CheckBox healthBadSleepField;
    @Autowired
    private CheckBox healthHasTraumaField;
    @Autowired
    private CheckBox healthBadCommunicationField;
    private List<CheckBox> eduCheckBoxesLow = new ArrayList<>();
    private List<CheckBox> eduCheckBoxesMedium = new ArrayList<>();
    private List<CheckBox> eduCheckBoxesHigh = new ArrayList<>();
    @Autowired
    private CheckBox eduNotLikeField;
    @Autowired
    private CheckBox eduNoSubjectField;
    @Autowired
    private CheckBox eduWorkingField;
    @Autowired
    private CheckBox eduNoDisciplineField;
    @Autowired
    private CheckBox eduSchoolFriendField;
    @Autowired
    private CheckBox eduSpecialNeedsField;
    @Autowired
    private CheckBox eduDifficultProgramField;
    @Autowired
    private CheckBox eduFreqAbsentField;
    @Autowired
    private CheckBox eduNoAttentionField;
    @Autowired
    private CheckBox eduNoClubField;
    @Autowired
    private CheckBox eduNoStationeryField;
    @Autowired
    private CheckBox eduNoLaptopField;
    @Autowired
    private CheckBox eduNoUniformField;
    @Autowired
    private CheckBox eduConflictField;
    @Autowired
    private CheckBox eduNoDeskField;
    @Autowired
    private CheckBox eduAmoralAbsentField;
    @Autowired
    private CheckBox eduLowMotivationField;

    private List<CheckBox> emoCheckBoxesLow = new ArrayList<>();
    private List<CheckBox> emoCheckBoxesMedium = new ArrayList<>();
    private List<CheckBox> emoCheckBoxesHigh = new ArrayList<>();
    @Autowired
    private CheckBox emoNoStabilityField;
    @Autowired
    private CheckBox emoAnxietyField;
    @Autowired
    private CheckBox emoNoFriendsField;
    @Autowired
    private CheckBox emoDepressionField;
    @Autowired
    private CheckBox emoBullyingField;
    @Autowired
    private CheckBox emoOutsideOfHomeField;
    @Autowired
    private CheckBox emoAloneField;
    @Autowired
    private CheckBox emoSelfHarassmentField;
    @Autowired
    private CheckBox emoRanAwayField;
    @Autowired
    private CheckBox emoIsBullyField;
    @Autowired
    private CheckBox emoRiskingActionField;
    @Autowired
    private CheckBox emoConflictWitnessField;
    @Autowired
    private CheckBox emoNoEmotionControlField;
    @Autowired
    private CheckBox emoSuicidialField;
    @Autowired
    private CheckBox emoSuicidialAttemptField;
    @Autowired
    private CheckBox emoStealsField;
    @Autowired
    private CheckBox emoOnRegisterField;
    @Autowired
    private CheckBox emoAggressorField;
    private List<CheckBox> identCheckBoxesLow = new ArrayList<>();
    private List<CheckBox> identCheckBoxesMedium = new ArrayList<>();
    private List<CheckBox> identCheckBoxesHigh = new ArrayList<>();
    @Autowired
    private CheckBox identDiscriminationField;
    @Autowired
    private CheckBox identNoFamilyField;
    @Autowired
    private CheckBox identGenderConfField;
    @Autowired
    private CheckBox identGenderDontKnowField;
    @Autowired
    private CheckBox identPositiveIndividualField;
    @Autowired
    private CheckBox identAgeSolField;
    @Autowired
    private CheckBox identNotSureMyselfField;
    @Autowired
    private CheckBox identNotSatisfiedField;
    @Autowired
    private CheckBox identNoCulturalField;
    @Autowired
    private CheckBox identNotIndependentField;
    @Autowired
    private CheckBox identNoHygieneField;
    private List<CheckBox> familyCheckBoxesLow = new ArrayList<>();
    private List<CheckBox> familyCheckBoxesMedium = new ArrayList<>();
    private List<CheckBox> familyCheckBoxesHigh = new ArrayList<>();
    @Autowired
    private CheckBox familyNoRelationshipField;
    @Autowired
    private CheckBox familyNoAdultField;
    @Autowired
    private CheckBox familyDomesticViolenceField;
    @Autowired
    private CheckBox familyNoConnectionField;
    @Autowired
    private CheckBox familyBadReviewField;
    @Autowired
    private CheckBox familyBadFriendsField;
    @Autowired
    private CheckBox familyNoSkillsField;
    @Autowired
    private CheckBox familyChildIsAdultField;
    @Autowired
    private CheckBox familyDifferentParentsField;
    @Autowired
    private CheckBox familyChildConflictField;
    @Autowired
    private CheckBox familyNoTimeCommunicationField;
    @Autowired
    private CheckBox familyAwayFromParentsField;
    @Autowired
    private CheckBox familySexualProblemsField;
    @Autowired
    private CheckBox familyChildParentConflictField;
    @Autowired
    private CheckBox familyChronicalDiseaseField;
    @Autowired
    private CheckBox familyHasJailField;
    @Autowired
    private CheckBox familyHasTraumaField;
    private List<CheckBox> selfCheckBoxesLow = new ArrayList<>();
    private List<CheckBox> selfCheckBoxesMedium = new ArrayList<>();
    private List<CheckBox> selfCheckBoxesHigh = new ArrayList<>();
    @Autowired
    private CheckBox selfNoPhysicialActivityField;
    @Autowired
    private CheckBox selfNoPracticalSkillsField;
    @Autowired
    private CheckBox selfNoMoneyField;
    @Autowired
    private CheckBox selfNoHelpField;
    private List<CheckBox> parentsCheckBoxesLow = new ArrayList<>();
    private List<CheckBox> parentsCheckBoxesMedium = new ArrayList<>();
    private List<CheckBox> parentsCheckBoxesHigh = new ArrayList<>();
    @Autowired
    private CheckBox parentsNoBasicField;
    @Autowired
    private CheckBox parentsNoDailyRoutineField;
    @Autowired
    private CheckBox parentsNoSpaceField;
    @Autowired
    private CheckBox parentsNoChildHealthField;
    @Autowired
    private CheckBox parentsNoPraisedField;
    @Autowired
    private CheckBox parentsNoSchoolField;
    @Autowired
    private CheckBox parentsDontKnowField;
    @Autowired
    private CheckBox parentsDontCareField;
    @Autowired
    private CheckBox parentNoDisciplineField;
    private List<CheckBox> homeCheckBoxesLow = new ArrayList<>();
    private List<CheckBox> homeCheckBoxesMedium = new ArrayList<>();
    private List<CheckBox> homeCheckBoxesHigh = new ArrayList<>();
    @Autowired
    private CheckBox homeNoHomeField;
    @Autowired
    private CheckBox homeEvictionField;
    @Autowired
    private CheckBox homeDangerField;
    @Autowired
    private CheckBox homeNoJobField;
    @Autowired
    private CheckBox homeNoBenefitsField;
    @Autowired
    private CheckBox homeNoMoneyField;
    @Autowired
    private GroupBoxLayout pivotTableGroupBox;
    @Autowired
    private CollectionPropertyContainer<PivotTableCheckBoxes> pivotTableCheckBoxesDc;
    @Autowired
    private DataManager dataManager;
    private String low = "Низкий";
    private String medium = "Средний";
    private String high = "Высокий";
    private String homeCategory = "ЖИЛЬЕ, РАБОТА, ДОХОД СЕМЬИ";
    private String parentsCategory = "БАЗОВЫЙ УХОД ОБЕСПЕЧЕНИЕ БЕЗОПАСНОСТИ";
    private String selfCategory = "НАВЫКИ СМООБСЛУЖИВАНИЯ/УХОД ЗА СОБОЙ";
    private String familyCategory = "СЕМЬЯ И СОЦИАЛЬНЫЕ ОТНОШЕНИЯ";
    private String identCategory = "ИДЕНТИЧНОСТЬ И СОЦИАЛЬНАЯ ПРЕЗЕНТАЦИЯ";
    private String emoCategory = "ЭМОЦИОНАЛЬНОЕ И ПОВЕДЕНЧЕСКОЕ РАЗВИТИЕ";
    private String eduCategory = "ОБРАЗОВАНИЕ";
    private String healthCategory = "ЗДОРОВЬЕ";
    @Autowired
    private HtmlAttributes htmlAttributes;
    @Autowired
    private GroupTable<PivotTableCheckBoxes> pivotGroupTable2;
    @Autowired
    private TextArea<String> healthChronicalTextField;
    @Autowired
    private ComboBox<HealthChronicalOption> healthChronicalOptionComboBox;
    @Autowired
    private TextArea<String> healthDisabledNoHelpTextField;
    @Autowired
    private TextArea<String> healthNoFoodTextField;
    @Autowired
    private TextArea<String> healthNoEquipmentTextField;
    @Autowired
    private TextArea<String> eduNotLikeTextField;
    @Autowired
    private TextArea<String> eduSpecialNeedsTextField;
    @Autowired
    private TextArea<String> eduDifficultProgramTextField;
    @Autowired
    private TextArea<String> eduFreqAbsentTextField;
    @Autowired
    private TextArea<String> eduNoAttentionTextField;
    @Autowired
    private TextArea<String> emoAnxietyTextField;
    @Autowired
    private TextArea<String> emoNoFriendsTextField;
    @Autowired
    private TextArea<String> emoDepressionTextField;
    @Autowired
    private TextArea<String> emoAloneTextField;
    @Autowired
    private TextArea<String> emoRiskingActionTextField;
    @Autowired
    private TextArea<String> emoConflictWitnessTextField;
    @Autowired
    private TextArea<String> emoOnRegisterTextField;
    @Autowired
    private TextArea<String> identDiscriminationTextField;
    @Autowired
    private TextArea<String> identGenderDontKnowTextField;
    @Autowired
    private TextArea<String> identAgeSolTextField;
    @Autowired
    private TextArea<String> familyNoRelationshipTextField;
    @Autowired
    private TextArea<String> familyBadReviewTextField;
    @Autowired
    private TextArea<String> familyBadFriendsTextField;
    @Autowired
    private TextArea<String> familyChildConflictTextField;
    @Autowired
    private TextArea<String> familySexualProblemsTextField;
    @Autowired
    private TextArea<String> familyChronicalDiseaseTextField;
    @Autowired
    private TextArea<String> familyHasTraumaTextField;
    @Autowired
    private TextArea<String> parentsNoBasicTextField;
    @Autowired
    private TextArea<String> homeDangerTextField;
    @Autowired
    private TextArea<String> homeNoJobTextField;
    @Autowired
    private TextArea<String> homeNoBenefitsTextField;
    @Autowired
    private TextArea<String> homeNoMoneyTextField;
    @Autowired
    private PivotTableMapper pivotTableMapper;
    @Autowired
    private CurrentAuthentication currentAuthentication;


    @Subscribe
    public void onInit(InitEvent event) {
        fillHealthCheckBoxes();
        fillEduCheckBoxes();
        fillEmoCheckBoxes();
        fillIdentCheckBoxes();
        fillFamilyCheckBoxes();
        fillSelfCheckBoxes();
        fillParentsCheckBoxes();
        fillHomeCheckBoxes();
    }

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        if (getEditedEntity().getCaseIdNum() == null) {
            String newCaseIdNum = getNewCaseIdNum();
            getEditedEntity().setCaseIdNum(newCaseIdNum);
        }
        if (getEditedEntity().getSchoolMask() != null) {
            return;
        }
        var user = (User) currentAuthentication.getUser();
        if (user.getMask() == null) {
            return;
        }
        var mask = user.getMask();
        getEditedEntity().setSchoolMask(mask);
        log.info("Set school mask to {}", mask);
    }

    @Subscribe
    public void onBeforeCommitChanges(final BeforeCommitChangesEvent event) {
        pivotTableCheckBoxesDc.getMutableItems().clear();
        log.info("Clearing pivot tables ... ");
    }

    private void fillHomeCheckBoxes() {
        homeCheckBoxesLow.add(homeNoHomeField);

        homeCheckBoxesMedium.add(homeEvictionField);
        homeCheckBoxesMedium.add(homeDangerField);
        homeCheckBoxesMedium.add(homeNoJobField);
        homeCheckBoxesMedium.add(homeNoBenefitsField);
        homeCheckBoxesMedium.add(homeNoMoneyField);
    }

    private void fillParentsCheckBoxes() {
        parentsCheckBoxesLow.add(parentsNoDailyRoutineField);
        parentsCheckBoxesLow.add(parentsNoPraisedField);
        parentsCheckBoxesLow.add(parentsDontKnowField);

        parentsCheckBoxesMedium.add(parentsNoSpaceField);
        parentsCheckBoxesMedium.add(parentsNoSchoolField);
        parentsCheckBoxesMedium.add(parentsDontCareField);
        parentsCheckBoxesMedium.add(parentNoDisciplineField);

        parentsCheckBoxesHigh.add(parentsNoBasicField);
        parentsCheckBoxesHigh.add(parentsNoChildHealthField);
    }

    private void fillSelfCheckBoxes() {
        selfCheckBoxesLow.add(selfNoPhysicialActivityField);
        selfCheckBoxesLow.add(selfNoPracticalSkillsField);
        selfCheckBoxesLow.add(selfNoMoneyField);
        selfCheckBoxesMedium.add(selfNoHelpField);
    }

    private void fillFamilyCheckBoxes() {
        familyCheckBoxesLow.add(familyDifferentParentsField);
        familyCheckBoxesLow.add(familyNoTimeCommunicationField);

        familyCheckBoxesMedium.add(familyNoRelationshipField);
        familyCheckBoxesMedium.add(familyNoAdultField);
        familyCheckBoxesMedium.add(familyNoConnectionField);
        familyCheckBoxesMedium.add(familyBadReviewField);
        familyCheckBoxesMedium.add(familyBadFriendsField);
        familyCheckBoxesMedium.add(familyNoSkillsField);
        familyCheckBoxesMedium.add(familyChildIsAdultField);
        familyCheckBoxesMedium.add(familyAwayFromParentsField);
        familyCheckBoxesMedium.add(familyChildParentConflictField);
        familyCheckBoxesMedium.add(familyChronicalDiseaseField);
        familyCheckBoxesMedium.add(familyHasJailField);
        familyCheckBoxesMedium.add(familyHasTraumaField);

        familyCheckBoxesHigh.add(familyDomesticViolenceField);
        familyCheckBoxesHigh.add(familyChildConflictField);
        familyCheckBoxesHigh.add(familySexualProblemsField);
    }

    private void fillIdentCheckBoxes() {
        identCheckBoxesLow.add(identNotSureMyselfField);
        identCheckBoxesLow.add(identNotSatisfiedField);
        identCheckBoxesLow.add(identNoCulturalField);
        identCheckBoxesLow.add(identNotIndependentField);

        identCheckBoxesMedium.add(identNoFamilyField);
        identCheckBoxesMedium.add(identGenderConfField);
        identCheckBoxesMedium.add(identPositiveIndividualField);
        identCheckBoxesMedium.add(identAgeSolField);
        identCheckBoxesMedium.add(identNoHygieneField);


        identCheckBoxesHigh.add(identDiscriminationField);
        identCheckBoxesHigh.add(identGenderDontKnowField);
    }

    private void fillEduCheckBoxes() {
        eduCheckBoxesHigh.add(eduNotLikeField);
        eduCheckBoxesHigh.add(eduSpecialNeedsField);
        eduCheckBoxesHigh.add(eduDifficultProgramField);
        eduCheckBoxesHigh.add(eduFreqAbsentField);
        eduCheckBoxesHigh.add(eduAmoralAbsentField);

        eduCheckBoxesMedium.add(eduWorkingField);
        eduCheckBoxesMedium.add(eduNoDisciplineField);
        eduCheckBoxesMedium.add(eduNoAttentionField);
        eduCheckBoxesMedium.add(eduNoStationeryField);
        eduCheckBoxesMedium.add(eduNoLaptopField);
        eduCheckBoxesMedium.add(eduNoUniformField);
        eduCheckBoxesMedium.add(eduConflictField);
        eduCheckBoxesMedium.add(eduNoDeskField);
        eduCheckBoxesMedium.add(eduLowMotivationField);

        eduCheckBoxesLow.add(eduNoSubjectField);
        eduCheckBoxesLow.add(eduSchoolFriendField);
        eduCheckBoxesLow.add(eduNoClubField);
    }

    private void fillHealthCheckBoxes() {
        healthCheckBoxesHigh.add(healthNoFoodField);
        healthCheckBoxesHigh.add(healthNoEquipmentField);
        healthCheckBoxesHigh.add(healthNoCoordinationField);
        healthCheckBoxesHigh.add(healthBadHabitsField);
        healthCheckBoxesHigh.add(healthWetsBedField);
        healthCheckBoxesHigh.add(healthBadCommunicationField);

        healthCheckBoxesMedium.add(healthChronicalField);
        healthCheckBoxesMedium.add(healthNoRegisteredField);
        healthCheckBoxesMedium.add(healthDisabledNoHelpField);
        healthCheckBoxesMedium.add(healthNoHospitalField);
        healthCheckBoxesMedium.add(healthNoTestingField);
        healthCheckBoxesMedium.add(healthBadWeightOrHeightField);
        healthCheckBoxesMedium.add(healthFobiaField);
        healthCheckBoxesMedium.add(healthBadSleepField);
        healthCheckBoxesMedium.add(healthHasTraumaField);

        healthCheckBoxesLow.add(healthNoVaccinationField);
        healthCheckBoxesLow.add(healthNoSportField);
    }

    private void fillEmoCheckBoxes() {
        emoCheckBoxesMedium.add(emoNoStabilityField);
        emoCheckBoxesMedium.add(emoNoFriendsField);
        emoCheckBoxesMedium.add(emoOutsideOfHomeField);
        emoCheckBoxesMedium.add(emoAloneField);
        emoCheckBoxesMedium.add(emoSelfHarassmentField);
        emoCheckBoxesMedium.add(emoRanAwayField);
        emoCheckBoxesMedium.add(emoIsBullyField);
        emoCheckBoxesMedium.add(emoRiskingActionField);
        emoCheckBoxesMedium.add(emoConflictWitnessField);
        emoCheckBoxesMedium.add(emoNoEmotionControlField);
        emoCheckBoxesMedium.add(emoStealsField);
        emoCheckBoxesMedium.add(emoOnRegisterField);

        emoCheckBoxesHigh.add(emoAnxietyField);
        emoCheckBoxesHigh.add(emoDepressionField);
        emoCheckBoxesHigh.add(emoBullyingField);
        emoCheckBoxesHigh.add(emoSuicidialField);
        emoCheckBoxesHigh.add(emoSuicidialAttemptField);
        emoCheckBoxesHigh.add(emoAggressorField);
    }

    @Subscribe("calculatePivotTable")
    public void onCalculatePivotTableClick(Button.ClickEvent event) {
        pivotTableCheckBoxesDc.getMutableItems().clear();
        for (PivotTableCheckBoxes pivotTableCheckBoxes : pivotTableMapper.convert(getEditedEntity())) {
            pivotTableCheckBoxesDc.getMutableItems().add(pivotTableCheckBoxes);
        }

        calcPivotTableHealth();
        calcPivotTableEdu();
        calcPivotTableEmo();
        calcPivotTableIdent();
        calcPivotTableFamily();
        calcPivotTableSelf();
        calcPivotTableParents();
        calcPivotTableHome();
        pivotTableGroupBox.setVisible(true);
    }

    private void calcPivotTableHome() {
        boolean homeLowFlag = homeCheckBoxesLow.stream().anyMatch(CheckBox::isChecked);
        boolean homeMediumFlag = homeCheckBoxesMedium.stream().anyMatch(CheckBox::isChecked);
        boolean homeHighFlag = homeCheckBoxesHigh.stream().anyMatch(CheckBox::isChecked);
        getEditedEntity().setHomeLow(homeLowFlag);
        getEditedEntity().setHomeMedium(homeMediumFlag);
        getEditedEntity().setHomeHigh(homeHighFlag);
    }

    private void calcPivotTableParents() {
        boolean parentsLowFlag = parentsCheckBoxesLow.stream().anyMatch(CheckBox::isChecked);
        boolean parentsMediumFlag = parentsCheckBoxesMedium.stream().anyMatch(CheckBox::isChecked);
        boolean parentsHighFlag = parentsCheckBoxesHigh.stream().anyMatch(CheckBox::isChecked);
        getEditedEntity().setParentsLow(parentsLowFlag);
        getEditedEntity().setParentsMedium(parentsMediumFlag);
        getEditedEntity().setParentsHigh(parentsHighFlag);
    }

    private void calcPivotTableSelf() {
        boolean selfLowFlag = selfCheckBoxesLow.stream().anyMatch(CheckBox::isChecked);
        boolean selfMediumFlag = selfCheckBoxesMedium.stream().anyMatch(CheckBox::isChecked);
        boolean selfHighFlag = selfCheckBoxesHigh.stream().anyMatch(CheckBox::isChecked);
        getEditedEntity().setSelfLow(selfLowFlag);
        getEditedEntity().setSelfMedium(selfMediumFlag);
        getEditedEntity().setSelfHigh(selfHighFlag);
    }

    private void calcPivotTableFamily() {
        boolean familyLowFlag = familyCheckBoxesLow.stream().anyMatch(CheckBox::isChecked);
        boolean familyMediumFlag = familyCheckBoxesMedium.stream().anyMatch(CheckBox::isChecked);
        boolean familyHighFlag = familyCheckBoxesHigh.stream().anyMatch(CheckBox::isChecked);
        getEditedEntity().setFamilyLow(familyLowFlag);
        getEditedEntity().setFamilyMedium(familyMediumFlag);
        getEditedEntity().setFamilyHigh(familyHighFlag);
    }

    private void calcPivotTableIdent() {
        boolean identLowFlag = identCheckBoxesLow.stream().anyMatch(CheckBox::isChecked);
        boolean identMediumFlag = identCheckBoxesMedium.stream().anyMatch(CheckBox::isChecked);
        boolean identHighFlag = identCheckBoxesHigh.stream().anyMatch(CheckBox::isChecked);
        getEditedEntity().setIdentLow(identLowFlag);
        getEditedEntity().setIdentMedium(identMediumFlag);
        getEditedEntity().setIdentHigh(identHighFlag);
    }

    private void calcPivotTableEmo() {
        boolean emoLowFlag = emoCheckBoxesLow.stream().anyMatch(CheckBox::isChecked);
        boolean emoMediumFlag = emoCheckBoxesMedium.stream().anyMatch(CheckBox::isChecked);
        boolean emoHighFlag = emoCheckBoxesHigh.stream().anyMatch(CheckBox::isChecked);
        getEditedEntity().setEmoLow(emoLowFlag);
        getEditedEntity().setEmoMedium(emoMediumFlag);
        getEditedEntity().setEmoHigh(emoHighFlag);
    }

    private void calcPivotTableEdu() {
        boolean eduLowFlag = eduCheckBoxesLow.stream().anyMatch(CheckBox::isChecked);
        boolean eduMediumFlag = eduCheckBoxesMedium.stream().anyMatch(CheckBox::isChecked);
        boolean eduHighFlag = eduCheckBoxesHigh.stream().anyMatch(CheckBox::isChecked);
        getEditedEntity().setEduLow(eduLowFlag);
        getEditedEntity().setEduMedium(eduMediumFlag);
        getEditedEntity().setEduHigh(eduHighFlag);
    }

    private void calcPivotTableHealth() {
        boolean healthLowFlag = healthCheckBoxesLow.stream().anyMatch(CheckBox::isChecked);
        boolean healthMediumFlag = healthCheckBoxesMedium.stream().anyMatch(CheckBox::isChecked);
        boolean healthHighFlag = healthCheckBoxesHigh.stream().anyMatch(CheckBox::isChecked);
        getEditedEntity().setHealthLow(healthLowFlag);
        getEditedEntity().setHealthMedium(healthMediumFlag);
        getEditedEntity().setHealthHigh(healthHighFlag);
    }

    private String getNewCaseIdNum() {
        int lastCaseIdNum = dataManager.loadValue("select max(cast(e.caseIdNum integer)) from SecondForm e", Integer.class)
                .optional()
                .orElse(0);
        return String.format("%06d", lastCaseIdNum + 1);
    }

    @Subscribe("healthChronicalField")
    public void onHealthChronicalFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        healthChronicalOptionComboBox.setVisible(event.getValue());
    }

    @Subscribe("healthChronicalOptionComboBox")
    public void onHealthChronicalOptionComboBoxValueChange(final HasValue.ValueChangeEvent<HealthChronicalOption> event) {
        if (HealthChronicalOption.ДРУГОЕ.equals(event.getValue())) {
            getEditedEntity().setHealthChronicalText("");
            healthChronicalTextField.setVisible(true);
        } else {
            healthChronicalTextField.setVisible(false);
            getEditedEntity().setHealthChronicalText(event.getValue().getId());
        }
    }

    @Subscribe("healthDisabledNoHelpField")
    public void onHealthDisabledNoHelpFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setHealthDisabledNoHelpText("");
        }
        healthDisabledNoHelpTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("healthNoFoodField")
    public void onHealthNoFoodFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setHealthNoFoodText("");
        }
        healthNoFoodTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("healthNoEquipmentField")
    public void onHealthNoEquipmentFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setHealthNoEquipmentText("");
        }
        healthNoEquipmentTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("eduNotLikeField")
    public void onEduNotLikeFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setEduNotLikeText("");
        }
        eduNotLikeTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("eduSpecialNeedsField")
    public void onEduSpecialNeedsFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setEduSpecialNeedsText("");
        }
        eduSpecialNeedsTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("eduDifficultProgramField")
    public void onEduDifficultProgramFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setEduDifficultProgramText("");
        }
        eduDifficultProgramTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("eduFreqAbsentField")
    public void onEduFreqAbsentFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setEduFreqAbsentText("");
        }
        eduFreqAbsentTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("eduNoAttentionField")
    public void onEduNoAttentionFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setEduNoAttentionText("");
        }
        eduNoAttentionTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("emoAnxietyField")
    public void onEmoAnxietyFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setEmoAnxietyText("");
        }
        emoAnxietyTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("emoNoFriendsField")
    public void onEmoNoFriendsFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setEmoNoFriendsText("");
        }
        emoNoFriendsTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("emoDepressionField")
    public void onEmoDepressionFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setEmoDepressionText("");
        }
        emoDepressionTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("emoAloneField")
    public void onEmoAloneFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setEmoAloneText("");
        }
        emoAloneTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("emoRiskingActionField")
    public void onEmoRiskingActionFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setEmoRiskingActionText("");
        }
        emoRiskingActionTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("emoConflictWitnessField")
    public void onEmoConflictWitnessFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setEmoConflictWitnessText("");
        }
        emoConflictWitnessTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("emoOnRegisterField")
    public void onEmoOnRegisterFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setEmoOnRegisterText("");
        }
        emoOnRegisterTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("identDiscriminationField")
    public void onIdentDiscriminationFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setIdentDiscriminationText("");
        }
        identDiscriminationTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("identGenderDontKnowField")
    public void onIdentGenderDontKnowFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setIdentGenderDontKnowText("");
        }
        identGenderDontKnowTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("identAgeSolField")
    public void onIdentAgeSolFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setIdentAgeSolText("");
        }
        identAgeSolTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("familyNoRelationshipField")
    public void onFamilyNoRelationshipFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setFamilyNoRelationshipText("");
        }
        familyNoRelationshipTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("familyBadReviewField")
    public void onFamilyBadReviewFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setFamilyBadReviewText("");
        }
        familyBadReviewTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("familyBadFriendsField")
    public void onFamilyBadFriendsFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setFamilyBadFriendsText("");
        }
        familyBadFriendsTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("familyChildConflictField")
    public void onFamilyChildConflictFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setFamilyChildConflictText("");
        }
        familyChildConflictTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("familySexualProblemsField")
    public void onFamilySexualProblemsFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setFamilySexualProblemsText("");
        }
        familySexualProblemsTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("familyChronicalDiseaseField")
    public void onFamilyChronicalDiseaseFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setFamilyChronicalDiseaseText("");
        }
        familyChronicalDiseaseTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("familyHasTraumaField")
    public void onFamilyHasTraumaFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setFamilyHasTraumaText("");
        }
        familyHasTraumaTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("parentsNoBasicField")
    public void onParentsNoBasicFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setParentsNoBasicText("");
        }
        parentsNoBasicTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("homeDangerField")
    public void onHomeDangerFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setHomeDangerText("");
        }
        homeDangerTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("homeNoJobField")
    public void onHomeNoJobFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setHomeNoJobText("");
        }
        homeNoJobTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("homeNoBenefitsField")
    public void onHomeNoBenefitsFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setHomeNoBenefitsText("");
        }
        homeNoBenefitsTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }

    @Subscribe("homeNoMoneyField")
    public void onHomeNoMoneyFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {
        if (!Boolean.TRUE.equals(event.getValue())) {
            getEditedEntity().setHomeNoMoneyText("");
        }
        homeNoMoneyTextField.setVisible(Boolean.TRUE.equals(event.getValue()));
    }
}
