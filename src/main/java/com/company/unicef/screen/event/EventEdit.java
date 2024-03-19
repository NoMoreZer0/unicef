package com.company.unicef.screen.event;

import com.company.unicef.entity.EventUser;
import com.company.unicef.entity.Parent;
import com.company.unicef.entity.User;
import com.company.unicef.screen.parent.ParentBrowseImmutable;
import com.company.unicef.screen.user.UserBrowse;
import com.company.unicef.screen.user.UserBrowseImmutable;
import io.jmix.core.DataManager;
import io.jmix.core.Metadata;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.action.list.AddAction;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.Table;
import io.jmix.ui.model.*;
import io.jmix.ui.screen.*;
import com.company.unicef.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@UiController("Event.edit")
@UiDescriptor("event-edit.xml")
@EditedEntityContainer("eventDc")
public class EventEdit extends StandardEditor<Event> {
    @Autowired
    private Table<User> eventUsersTable;
    @Autowired
    private ScreenBuilders screenBuilders;
    @Autowired
    private CollectionPropertyContainer<EventUser> eventUsersDc;
    @Autowired
    private DataContext dataContext;
    @Named("parentsTable.add")
    private AddAction<Parent> parentsTableAdd;
    
    @Subscribe("eventUsersTable.add")
    public void onEventUsersTableAdd(final Action.ActionPerformedEvent event) {
        screenBuilders.lookup(User.class, this)
                .withOpenMode(OpenMode.DIALOG)
                .withScreenClass(UserBrowseImmutable.class)
                .withSelectHandler(selectedUsers -> {
                    if (selectedUsers.isEmpty()) {
                        return;
                    }
                    selectedUsers.forEach(u -> {
                        var eventUser = dataContext.create(EventUser.class);
                        eventUser.setUser(u);
                        eventUser.setEvent(getEditedEntity());
                        eventUsersDc.getMutableItems().add(eventUser);
                    });
                })
                .build()
                .show();
    }

}