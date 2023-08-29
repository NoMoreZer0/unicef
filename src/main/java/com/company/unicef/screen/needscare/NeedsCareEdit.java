package com.company.unicef.screen.needscare;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsCare;

@UiController("NeedsCare.edit")
@UiDescriptor("needs-care-edit.xml")
@EditedEntityContainer("needsCareDc")
public class NeedsCareEdit extends StandardEditor<NeedsCare> {
}