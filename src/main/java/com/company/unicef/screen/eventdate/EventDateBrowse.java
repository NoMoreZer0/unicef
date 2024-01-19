package com.company.unicef.screen.eventdate;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.EventDate;

@UiController("EventDate.browse")
@UiDescriptor("event-date-browse.xml")
@LookupComponent("eventDatesTable")
public class EventDateBrowse extends StandardLookup<EventDate> {
}