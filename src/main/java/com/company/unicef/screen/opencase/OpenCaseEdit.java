package com.company.unicef.screen.opencase;

import com.company.unicef.app.PivotTableMapper;
import com.company.unicef.entity.*;
import io.jmix.core.DataManager;
import io.jmix.core.Messages;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.reportsui.screen.template.edit.generator.RandomPivotTableDataGenerator;
import io.jmix.ui.Notifications;
import io.jmix.ui.UiComponents;
import io.jmix.ui.component.*;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@UiController("OpenCase.edit")
@UiDescriptor("open-case-edit.xml")
@EditedEntityContainer("openCaseDc")
public class OpenCaseEdit extends StandardEditor<OpenCase> {
    private static final Logger log = LoggerFactory.getLogger(
            OpenCaseEdit.class
    );

    @Inject
    protected DataManager dataManager;
    @Inject
    private CollectionPropertyContainer<SecondFormCheckBox> secondFormCheckBoxes;
    @Inject
    private Table<SecondFormCheckBox> secondFormCheckBoxTable;
    @Inject
    private Messages messages;
    private Boolean initFlag = false;
    private String healthCategory = "category.health";
    private String educationCategory = "category.education";
    private String emotionalCategory = "category.emotional";
    private String identityCategory = "category.identity";
    private String familyCategory = "category.family";
    private String careCategory = "category.care";
    private String homeCategory = "category.home";
    private String secondFormNotSelectedAlert = "com.company.unicef.screen.opencase/openCaseEdit.secondFormNotSelectedAlert";
    private Map<String, String> categoryMap = new HashMap<>();
    private Map<String, String> checkBoxToTextMap = new HashMap<>();
    @Autowired
    private RandomPivotTableDataGenerator randomPivotTableDataGenerator;
    @Autowired
    private GroupBoxLayout secondFormCheckBoxesGroup;
    @Autowired
    private UiComponents uiComponents;
    @Autowired
    private CollectionContainer<PivotTableCheckBoxes> pivotTableCheckBoxesDc;
    @Autowired
    private PivotTableMapper pivotTableMapper;
    @Autowired
    private DataContext dataContext;
    @Autowired
    private EntityPicker<SecondForm> secondFormField;
    @Autowired
    private Notifications notifications;
    @Autowired
    private CurrentAuthentication currentAuthentication;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        if (getEditedEntity().getSecondForm() != null) {
            initFlag = true;
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
        log.info("Set school mask {}", mask);
    }

    @Subscribe("calculateSecondForm")
    public void onCalculateSecondFormClick(final Button.ClickEvent event) throws IllegalAccessException {
        log.info("Calculating secondFormCheckboxes .. ");
        dataManager.remove(getEditedEntity().getSecondFormCheckBoxes());
        secondFormCheckBoxes.getMutableItems().clear();
        var secondForm = secondFormField.getValue();

        if (secondForm == null) {
            notifications.create()
                    .withCaption(messages.getMessage(secondFormNotSelectedAlert))
                    .withType(Notifications.NotificationType.HUMANIZED)
                    .show();
            return;
        }

        Field[] fields = secondForm.getClass().getDeclaredFields();
        List<String> fieldNames = getFieldNames(fields, secondForm);
        checkSecondFormFields(fieldNames);
        addEventColumn();

        if (getEditedEntity().getSecondForm() != null) {
            fillPivotTableCheckBoxes();
        }
    }



    private void fillPivotTableCheckBoxes() {
        pivotTableCheckBoxesDc.getMutableItems().clear();
        List<PivotTableCheckBoxes> checkBoxes = pivotTableMapper.convert(getEditedEntity().getSecondForm());
        for (PivotTableCheckBoxes checkBox : checkBoxes) {
            pivotTableCheckBoxesDc.getMutableItems().add(checkBox);
        }
    }

    private void addEventColumn() {
        String eventsColumnName = messages.getMessage("com.company.unicef.entity/SecondFormCheckBox.secondFormEventsBox");
        secondFormCheckBoxTable.addGeneratedColumn(eventsColumnName, new Table.ColumnGenerator<SecondFormCheckBox>() {
            @Nullable
            @Override
            public Component generateCell(SecondFormCheckBox entity) {
                Label<String> label = uiComponents.create(Label.NAME);
                label.setValue(entity.getSecondFormEvents().stream()
                        .map(Event::getName).collect(Collectors.joining("\n")));
                return label;
            }
        });
    }

    private List<String> getFieldNames(Field[] fields, SecondForm curSecondForm) throws IllegalAccessException {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields) {
            Class<?> fieldType = field.getType();
            if (fieldType.getName().equals("java.lang.Boolean")) {
                field.setAccessible(true);
                if (field.get(curSecondForm) == null) continue;
                Boolean value = (Boolean) field.get(curSecondForm);
                if (value != null && value) {
                    fieldNames.add(field.getName());
                }
            }
            else if (fieldType.getName().equals("java.lang.String")) {
                field.setAccessible(true);
                if (field.get(curSecondForm) == null) continue;
                String str = (String) field.get(curSecondForm);
                if (str != null && !str.isEmpty() && field.getName().contains("Text")) {
                    checkBoxToTextMap.put(field.getName().replace("Text", ""), str);
                }
            }
        }
        return fieldNames;
    }

    private void checkNameField(String name, String target) {
        if (isContainsField(getFromMessages(name)) || !name.equals(target)) return;
        if (checkBoxToTextMap.containsKey(name)) {
            addToCollection(checkBoxToTextMap.get(name), getFromMessages(categoryMap.get(name)));
            return;
        }
        addToCollection(getFromMessages(name), getFromMessages(categoryMap.get(name)));
    }

    private List<String> getAllSecondFormFields() {
        List<String> all = new ArrayList<>();
        all.add("healthChronical");
        categoryMap.put("healthChronical", healthCategory);
        all.add("healthDisabledNoHelp");
        categoryMap.put("healthDisabledNoHelp", healthCategory);
        all.add("healthNoFood");
        categoryMap.put("healthNoFood", healthCategory);
        all.add("healthNoEquipment");
        categoryMap.put("healthNoEquipment", healthCategory);
        all.add("healthBadHabits");
        categoryMap.put("healthBadHabits", healthCategory);
        all.add("healthWetsBed");
        categoryMap.put("healthWetsBed", healthCategory);
        all.add("healthBadCommunication");
        categoryMap.put("healthBadCommunication", healthCategory);
        all.add("eduNotLike");
        categoryMap.put("eduNotLike", educationCategory);
        all.add("eduSpecialNeeds");
        categoryMap.put("eduSpecialNeeds", educationCategory);
        all.add("eduDifficultProgram");
        categoryMap.put("eduDifficultProgram", educationCategory);
        all.add("eduFreqAbsent");
        categoryMap.put("eduFreqAbsent", educationCategory);
        all.add("eduNoAttention");
        categoryMap.put("eduNoAttention", educationCategory);
        all.add("emoAnxiety");
        categoryMap.put("emoAnxiety", emotionalCategory);
        all.add("emoNoFriends");
        categoryMap.put("emoNoFriends", emotionalCategory);
        all.add("emoDepression");
        categoryMap.put("emoDepression", emotionalCategory);
        all.add("emoBullying");
        categoryMap.put("emoBullying", emotionalCategory);
        all.add("emoAlone");
        categoryMap.put("emoAlone", emotionalCategory);
        all.add("emoRiskingAction");
        categoryMap.put("emoRiskingAction", emotionalCategory);
        all.add("emoConflictWitness");
        categoryMap.put("emoConflictWitness", emotionalCategory);
        all.add("emoOnRegister");
        categoryMap.put("emoOnRegister", emotionalCategory);
        all.add("identDiscrimination");
        categoryMap.put("identDiscrimination", identityCategory);
        all.add("identGenderDontKnow");
        categoryMap.put("identGenderDontKnow", identityCategory);
        all.add("identAgeSol");
        categoryMap.put("identAgeSol", identityCategory);
        all.add("familyNoRelationship");
        categoryMap.put("familyNoRelationship", familyCategory);
        all.add("familyBadReview");
        categoryMap.put("familyBadReview", familyCategory);
        all.add("familyBadFriends");
        categoryMap.put("familyBadFriends", familyCategory);
        all.add("familyChildConflict");
        categoryMap.put("familyChildConflict", familyCategory);
        all.add("familySexualProblems");
        categoryMap.put("familySexualProblems", familyCategory);
        all.add("familyChronicalDisease");
        categoryMap.put("familyChronicalDisease", familyCategory);
        all.add("familyHasTrauma");
        categoryMap.put("familyHasTrauma", familyCategory);
        all.add("parentsNoBasic");
        categoryMap.put("parentsNoBasic", careCategory);
        all.add("homeDanger");
        categoryMap.put("homeDanger", homeCategory);
        all.add("homeNoJob");
        categoryMap.put("homeNoJob", homeCategory);
        all.add("homeNoBenefits");
        categoryMap.put("homeNoBenefits", homeCategory);
        all.add("homeNoMoney");
        categoryMap.put("homeNoMoney", homeCategory);
        return all;
    }
    private void checkSecondFormFields(List<String> fieldNames) {
        List<String> allFields = getAllSecondFormFields();
        for (String name : fieldNames) {
            for (String secondFormFieldName : allFields) {
                checkNameField(name, secondFormFieldName);
            }
        }
    }

    private boolean isContainsField(String tableColumnName) {
        for (SecondFormCheckBox secondFormCheckBox : getEditedEntity().getSecondFormCheckBoxes()) {
            if (secondFormCheckBox.getName().equals(tableColumnName)) return true;
        }
        return false;
    }
    private void addToCollection(String tableColumnName, String tableColumnCategory) {
        SecondFormCheckBox secondFormCheckBox = dataManager.create(SecondFormCheckBox.class);
        secondFormCheckBox.setName(tableColumnName);
        secondFormCheckBox.setCategory(tableColumnCategory);
        secondFormCheckBox.setOpenCase(getEditedEntity());
        getEditedEntity().getSecondFormCheckBoxes().add(secondFormCheckBox);
        secondFormCheckBoxes.getDisconnectedItems().add(secondFormCheckBox);
    }

    private String getFromMessages(String messageName) {
        return messages.getMessage("com.company.unicef.entity", "SecondForm." + messageName);
    }

    @Subscribe("statusField")
    public void onStatusFieldValueChange(final HasValue.ValueChangeEvent<CaseStatus> event) {
        if (CaseStatus.CLOSED.equals(event.getValue())) {
            getEditedEntity().setClosingDate(new Date());
        } else {
            getEditedEntity().setClosingDate(null);
        }
    }

    @Subscribe
    public void onBeforeCommitChanges(final BeforeCommitChangesEvent event) {

    }
    
    

    @Subscribe
    public void onAfterShow(final AfterShowEvent event) {
        if (getEditedEntity().getSecondForm() != null) {
            fillPivotTableCheckBoxes();
        }
    }
}
