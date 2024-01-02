package com.company.unicef.screen.mainscreentopmenu;

import com.company.unicef.entity.User;
import com.company.unicef.screen.user.UserProfileEdit;
import io.jmix.core.usersubstitution.CurrentUserSubstitution;
import io.jmix.notifications.NotificationManager;
import io.jmix.notifications.NotificationType;
import io.jmix.notifications.NotificationTypesRepository;
import io.jmix.ui.*;
import io.jmix.ui.component.AppWorkArea;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.Image;
import io.jmix.ui.component.Window;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiControllerUtils;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@UiController("MainTop")
@UiDescriptor("main-screen-top-menu.xml")
@Route(path = "main", root = true)
public class MainScreenTopMenu extends Screen implements Window.HasWorkArea {

    @Autowired
    NotificationManager notificationManager;


    @Autowired
    private ScreenTools screenTools;

    @Autowired
    private AppWorkArea workArea;
    @Autowired
    private UiComponents uiComponents;
    @Autowired
    private ScreenBuilders screenBuilders;
    @Autowired
    private Screens screens;
    @Autowired
    private CurrentUserSubstitution currentUserSubstitution;

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
        UserProfileEdit userProfileEdit = screens.create(UserProfileEdit.class);
        userProfileEdit.setEntityToEdit((User)currentUserSubstitution.getAuthenticatedUser());
        userProfileEdit.show();
    }


}