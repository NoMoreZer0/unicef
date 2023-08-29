package com.company.unicef.screen.secondformcheckbox;

import com.company.unicef.entity.*;
import io.jmix.core.DataManager;
import io.jmix.core.Messages;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.component.Button;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.screen.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("SecondFormCheckBox.edit")
@UiDescriptor("second-form-check-box-edit.xml")
@EditedEntityContainer("secondFormCheckBoxDc")
public class SecondFormCheckBoxEdit extends StandardEditor<SecondFormCheckBox> {
    private static final Logger log = LoggerFactory.getLogger(SecondFormCheckBoxEdit.class);
    @Autowired
    private Messages messages;
    private String healthMsg;
    private String educationMsg;
    private String identityMsg;
    private String emotionalMsg;
    private String familyMsg;
    private String selfServiceMsg;
    private String careMsg;
    private String homeMsg;
    @Autowired
    private ScreenBuilders screenBuilders;
    @Autowired
    private CollectionPropertyContainer<NeedNames> needNamesDc;
    @Autowired
    private DataManager dataManager;

    @Subscribe
    public void onInit(InitEvent event) {
        healthMsg = messages.getMessage("com.company.unicef.entity/SecondForm.category.health");
        educationMsg = messages.getMessage("com.company.unicef.entity/SecondForm.category.education");
        emotionalMsg = messages.getMessage("com.company.unicef.entity/SecondForm.category.emotional");
        identityMsg = messages.getMessage("com.company.unicef.entity/SecondForm.category.identity");
        familyMsg = messages.getMessage("com.company.unicef.entity/SecondForm.category.family");
        selfServiceMsg = messages.getMessage("com.company.unicef.entity/SecondForm.category.self-service");
        careMsg = messages.getMessage("com.company.unicef.entity/SecondForm.category.care");
        homeMsg = messages.getMessage("com.company.unicef.entity/SecondForm.category.home");
    }

    @Subscribe("addNeedNamesButton")
    public void onAddNeedNamesButtonClick(final Button.ClickEvent event) {
        if (getEditedEntity().getCategory() == null) return;
        String category = getEditedEntity().getCategory();
        if (healthMsg.equals(category)) {
            addFromLookUpScreen(NeedsHealth.class);
        }
        if (educationMsg.equals(category)) {
            addFromLookUpScreen(NeedsEducation.class);
        }
        if (emotionalMsg.equals(category)) {
            addFromLookUpScreen(NeedsEducation.class);
        }
        if (identityMsg.equals(category)) {
            addFromLookUpScreen(NeedsIdentity.class);
        }
        if (familyMsg.equals(category)) {
            addFromLookUpScreen(NeedsFamily.class);
        }
        if (selfServiceMsg.equals(category)) {
            addFromLookUpScreen(NeedsSelf.class);
        }
        if (careMsg.equals(category)) {
            addFromLookUpScreen(NeedsCare.class);
        }
        if (homeMsg.equals(category)) {
            addFromLookUpScreen(NeedsHome.class);
        }
    }

    private <T extends Needs> void addFromLookUpScreen(Class<T> needs) {
        screenBuilders.lookup(needs, this)
                .withSelectHandler(needsSelected -> needsSelected.forEach(currentNeeds -> {
                   NeedNames currentName = dataManager.create(NeedNames.class);
                   currentName.setName(currentNeeds.getName());
                   currentName.setSecondFormCheckBox(getEditedEntity());
                   needNamesDc.getMutableItems().add(currentName);
                }))
                .build()
                .show();
    }
}