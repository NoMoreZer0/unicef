package com.company.unicef.screen.firstform;

import com.company.unicef.entity.FirstForm;
import com.company.unicef.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.Messages;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.securitydata.entity.RoleAssignmentEntity;
import io.jmix.ui.Notifications;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("FirstForm.browse")
@UiDescriptor("first-form-browse.xml")
@LookupComponent("firstFormsTable")
public class FirstFormBrowse extends StandardLookup<FirstForm> {
    @Autowired
    private CurrentAuthentication currentAuthentication;
    @Autowired
    private CollectionLoader<FirstForm> firstFormsDl;
    @Autowired
    private Notifications notifications;
    @Autowired
    private Messages messages;
    @Autowired
    private DataManager dataManager;

    private final String NO_SCHOOL_MASK = "io.jmix.app.notifications.noSchoolMask";
    private final String ERR_PARAMETR = "SOME ERROR";

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        var user = (User) currentAuthentication.getUser();

        user = dataManager.load(User.class)
                .id(user.getId())
                .one(); // refresh current user just in case

        if (isAdmin()) {
            firstFormsDl.removeParameter("userMask");
        } else {
            if (user.getMask() != null) {
                firstFormsDl.setParameter("userMask", user.getMask());
            } else {
                notifications.create()
                        .withType(Notifications.NotificationType.HUMANIZED)
                        .withCaption(messages.getMessage(NO_SCHOOL_MASK))
                        .show();
                firstFormsDl.setParameter("userMask", ERR_PARAMETR); // TODO: Ультра костыль, следует убрать как разберусь
            }
        }

        firstFormsDl.load();
    }

    private boolean isAdmin() {
        var user = (User) currentAuthentication.getUser();

        var opt = dataManager.load(RoleAssignmentEntity.class)
                .query("select r from sec_RoleAssignmentEntity r " +
                        "where r.username = :username and r.roleCode = 'system-full-access' ")
                .parameter("username", user.getUsername())
                .optional();

        return opt.isPresent();
    }
}