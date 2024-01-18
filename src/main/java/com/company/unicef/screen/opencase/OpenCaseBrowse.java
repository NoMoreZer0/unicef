package com.company.unicef.screen.opencase;

import com.company.unicef.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.Messages;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.securitydata.entity.RoleAssignmentEntity;
import io.jmix.ui.Notifications;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.unicef.entity.OpenCase;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("OpenCase.browse")
@UiDescriptor("open-case-browse.xml")
@LookupComponent("openCasesTable")
public class OpenCaseBrowse extends StandardLookup<OpenCase> {
    @Autowired
    private CurrentAuthentication currentAuthentication;
    @Autowired
    private Notifications notifications;
    @Autowired
    private Messages messages;
    @Autowired
    private DataManager dataManager;
    @Autowired
    private CollectionLoader<OpenCase> openCasesDl;

    private final String NO_SCHOOL_MASK = "io.jmix.app.notifications.noSchoolMask";
    private final String ERR_PARAMETR = "SOME ERROR";


    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        var user = (User) currentAuthentication.getUser();

        user = dataManager.load(User.class)
                .id(user.getId())
                .one(); // refresh current user just in case

        if (isAdmin()) {
            openCasesDl.removeParameter("userMask");
        } else {
            if (user.getMask() != null) {
                openCasesDl.setParameter("userMask", user.getMask());
            } else {
                notifications.create()
                        .withType(Notifications.NotificationType.HUMANIZED)
                        .withCaption(messages.getMessage(NO_SCHOOL_MASK))
                        .show();
                openCasesDl.setParameter("userMask", ERR_PARAMETR); // TODO: Ультра костыль, следует убрать как разберусь
            }
        }

        openCasesDl.load();
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