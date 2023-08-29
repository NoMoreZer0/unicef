package com.company.unicef.screen.opencase;

import com.company.unicef.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.unicef.entity.OpenCase;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import java.util.ArrayList;

@UiController("OpenCase.browseAll")
@UiDescriptor("open-case-browse-all.xml")
@LookupComponent("openCasesTable")
public class OpenCaseBrowseAll extends StandardLookup<OpenCase> {
    @Inject
    private CollectionLoader<OpenCase> openCasesDl;
    @Inject
    private CurrentAuthentication currentAuthentication;

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        User user = (User) currentAuthentication.getUser();
        if (user.getUsername().equals("admin")) return;
        ArrayList<OpenCase> allCases = new ArrayList<>(openCasesDl.getContainer().getMutableItems());
        for (OpenCase openCase : allCases) {
        }
    }

}