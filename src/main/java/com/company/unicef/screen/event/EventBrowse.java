package com.company.unicef.screen.event;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Event;

@UiController("Event.browse")
@UiDescriptor("event-browse.xml")
@LookupComponent("eventsTable")
public class EventBrowse extends StandardLookup<Event> {

}