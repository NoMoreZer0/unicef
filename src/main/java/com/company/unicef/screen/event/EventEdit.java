package com.company.unicef.screen.event;

import com.company.unicef.entity.EventUser;
import com.company.unicef.entity.User;
import io.jmix.core.DataManager;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.Table;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.InstanceLoader;
import io.jmix.ui.screen.*;
import com.company.unicef.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Event.edit")
@UiDescriptor("event-edit.xml")
@EditedEntityContainer("eventDc")
public class EventEdit extends StandardEditor<Event> {
    @Autowired
    private CollectionLoader<User> usersDl;
    @Autowired
    private Table<User> eventUsersTable;
    @Autowired
    private DataManager dataManager;
    @Autowired
    private CollectionContainer<User> usersDc;

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        usersDl.setParameter("event", getEditedEntity());
    }

    @Subscribe("excludeUser")
    public void onExcludeUserClick(final Button.ClickEvent event) {
        var selectedUsers = eventUsersTable.getSelected().stream().toList();
        if (selectedUsers.isEmpty()) {
            return;
        }
        usersDc.getMutableItems().remove(selectedUsers);
    }

    @Subscribe("addUser")
    public void onAddUserClick(final Button.ClickEvent event) {
        var selectedUsers = eventUsersTable.getSelected().stream().toList();
        if (selectedUsers.isEmpty()) {
            return;
        }
    }
    
    

}