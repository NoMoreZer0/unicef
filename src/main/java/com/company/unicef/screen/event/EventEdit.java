package com.company.unicef.screen.event;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Event;

@UiController("Event.edit")
@UiDescriptor("event-edit.xml")
@EditedEntityContainer("eventDc")
public class EventEdit extends StandardEditor<Event> {
}