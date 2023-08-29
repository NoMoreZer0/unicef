package com.company.unicef.screen.opencase;

import com.company.unicef.entity.*;
import io.jmix.core.DataManager;
import io.jmix.core.Messages;
import io.jmix.core.Metadata;
import io.jmix.core.security.SystemAuthenticator;
import io.jmix.ui.Notifications;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.Table;
import io.jmix.ui.component.ValuePicker;
import io.jmix.ui.executor.BackgroundWorker;
import io.jmix.ui.executor.UIAccessor;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UiController("OpenCase.edit")
@UiDescriptor("open-case-edit.xml")
@EditedEntityContainer("openCaseDc")
public class OpenCaseEdit extends StandardEditor<OpenCase> {
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
    private String selfServiceCategory = "category.self-service";
    private String careCategory = "category.care";
    private String homeCategory = "category.home";
    private Map<String, String> categoryMap = new HashMap<>();

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        if (getEditedEntity().getSecondForm() != null) {
            initFlag = true;
        }
    }


    @Subscribe("secondFormField")
    public void onSecondFormFieldValueChange(HasValue.ValueChangeEvent<SecondForm> event) throws Exception{
        if (event.getValue() == null) return;

        if (Boolean.TRUE.equals(initFlag)) {
            initFlag = false;
            return;
        }

        if (event.getPrevValue() != null && event.getValue().hashCode() != event.getPrevValue().hashCode()) {
            secondFormCheckBoxes.getMutableItems().clear();
        }

        SecondForm curSecondForm = event.getValue();
        Field[] fields = curSecondForm.getClass().getDeclaredFields();
        List<String> fieldNames = getFieldNames(fields, curSecondForm);
        checkSecondFormFields(fieldNames);
    }

    private List<String> getFieldNames(Field[] fields, SecondForm curSecondForm) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
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
        }
        return fieldNames;
    }

    private void checkNameField(String name, String target) {
        if (name.equals(target) && !isContainsField(getFromMessages(name))) {
            addToCollection(getFromMessages(name), getFromMessages(categoryMap.get(name)));
        }
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
        secondFormCheckBoxes.getMutableItems().add(secondFormCheckBox);
    }

    private String getFromMessages(String messageName) {
        return messages.getMessage("com.company.unicef.entity", "SecondForm." + messageName);
    }
}