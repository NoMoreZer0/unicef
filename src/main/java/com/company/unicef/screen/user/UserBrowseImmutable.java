package com.company.unicef.screen.user;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.User;

@UiController("User.browse.immutable")
@UiDescriptor("user-browse-immutable.xml")
@LookupComponent("usersTable")
public class UserBrowseImmutable extends StandardLookup<User> {
}