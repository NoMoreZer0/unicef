package com.company.unicef.screen.secondform;

import com.company.unicef.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.Messages;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.securitydata.entity.RoleAssignmentEntity;
import io.jmix.ui.Notifications;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.unicef.entity.SecondForm;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("SecondForm.browse")
@UiDescriptor("second-form-browse.xml")
@LookupComponent("secondFormsTable")
public class SecondFormBrowse extends StandardLookup<SecondForm> {
    @Autowired
    private CollectionLoader<SecondForm> secondFormsDl;
    @Autowired
    private Notifications notifications;
    @Autowired
    private CurrentAuthentication currentAuthentication;
    @Autowired
    private DataManager dataManager;
    @Autowired
    private Messages messages;

    private final String NO_SCHOOL_MASK = "io.jmix.app.notifications.noSchoolMask";
    private final String ERR_PARAMETR = "SOME ERROR";

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        var user = (User) currentAuthentication.getUser();

        user = dataManager.load(User.class)
                .id(user.getId())
                .one(); // refresh current user just in case

        if (isAdmin()) {
            secondFormsDl.removeParameter("userMask");
        } else {
            if (user.getMask() != null) {
                secondFormsDl.setParameter("userMask", user.getMask());
            } else {
                notifications.create()
                        .withType(Notifications.NotificationType.HUMANIZED)
                        .withCaption(messages.getMessage(NO_SCHOOL_MASK))
                        .show();
                secondFormsDl.setParameter("userMask", ERR_PARAMETR); // TODO: Ультра костыль, следует убрать как разберусь
            }
        }

        secondFormsDl.load();
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