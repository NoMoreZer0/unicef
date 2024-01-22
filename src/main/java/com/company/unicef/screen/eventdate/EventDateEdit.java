package com.company.unicef.screen.eventdate;


import io.jmix.ui.component.HasValue;
import io.jmix.ui.screen.*;
import com.company.unicef.entity.EventDate;


@UiController("EventDate.edit")
@UiDescriptor("event-date-edit.xml")
@EditedEntityContainer("eventDateDc")
public class EventDateEdit extends StandardEditor<EventDate> {
    @Subscribe("hasHappenedField")
    public void onHasHappenedFieldValueChange(final HasValue.ValueChangeEvent<Boolean> event) {

    }
}