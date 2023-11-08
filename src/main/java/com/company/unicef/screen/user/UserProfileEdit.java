package com.company.unicef.screen.user;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.User;

@UiController("User.profile-edit")
@UiDescriptor("user-profile.xml")
@EditedEntityContainer("userDc")
public class UserProfileEdit extends StandardEditor<User> {
}