package com.company.unicef.screen.needshealth;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsHealth;

@UiController("NeedsHealth.edit")
@UiDescriptor("needs-health-edit.xml")
@EditedEntityContainer("needsHealthDc")
public class NeedsHealthEdit extends StandardEditor<NeedsHealth> {
}