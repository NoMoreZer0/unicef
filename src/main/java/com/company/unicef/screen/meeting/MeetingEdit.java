package com.company.unicef.screen.meeting;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Meeting;

@UiController("Meeting.edit")
@UiDescriptor("meeting-edit.xml")
@EditedEntityContainer("meetingDc")
public class MeetingEdit extends StandardEditor<Meeting> {
}