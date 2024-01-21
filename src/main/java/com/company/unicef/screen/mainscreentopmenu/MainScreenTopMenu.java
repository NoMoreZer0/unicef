package com.company.unicef.screen.mainscreentopmenu;

import com.company.unicef.entity.User;
import com.company.unicef.screen.user.UserEdit;
import com.vaadin.server.Page;
import io.jmix.core.usersubstitution.CurrentUserSubstitution;
import io.jmix.ui.ScreenTools;
import io.jmix.ui.Screens;
import io.jmix.ui.component.AppWorkArea;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.Image;
import io.jmix.ui.component.Window;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;
import io.jmix.ui.theme.ThemeVariantsManager;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("MainTop")
@UiDescriptor("main-screen-top-menu.xml")
@Route(path = "main", root = true)
public class MainScreenTopMenu extends Screen implements Window.HasWorkArea {

    @Autowired
    private ScreenTools screenTools;
    @Autowired
    private AppWorkArea workArea;
    @Autowired
    private Screens screens;
    @Autowired
    private CurrentUserSubstitution currentUserSubstitution;
    @Autowired
    private ThemeVariantsManager variantsManager;

    @Override
    public AppWorkArea getWorkArea() {
        return workArea;
    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        screenTools.openDefaultScreen(
                UiControllerUtils.getScreenContext(this).getScreens());

        screenTools.handleRedirect();
    }

    @Subscribe("logoImage")
    public void onLogoImageClick(final Image.ClickEvent event) {
        screenTools.openDefaultScreen(UiControllerUtils.getScreenContext(this).getScreens());
        screenTools.handleRedirect();
    }

    @Subscribe("profileButton")
    public void onProfileButtonClick(final Button.ClickEvent event) {
        var userEdit = screens.create(UserEdit.class);
        userEdit.setEntityToEdit((User)currentUserSubstitution.getAuthenticatedUser());
        userEdit.show();
    }


    @Subscribe("modeChangeButton")
    public void onModeChangeClick(final Button.ClickEvent event) {
        if (variantsManager.getThemeModeCookieValue() == null ||
                !variantsManager.getThemeModeCookieValue().equals("visually-impaired")) {
            variantsManager.setThemeMode("visually-impaired");
            variantsManager.setThemeSize("large");
        } else {
            variantsManager.setThemeMode("light");
            variantsManager.setThemeSize("medium");
        }
        Page.getCurrent().reload();
    }
}