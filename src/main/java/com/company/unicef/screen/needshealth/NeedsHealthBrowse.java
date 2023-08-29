package com.company.unicef.screen.needshealth;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsHealth;

@UiController("NeedsHealth.browse")
@UiDescriptor("needs-health-browse.xml")
@LookupComponent("needsHealthsTable")
public class NeedsHealthBrowse extends StandardLookup<NeedsHealth> {
}