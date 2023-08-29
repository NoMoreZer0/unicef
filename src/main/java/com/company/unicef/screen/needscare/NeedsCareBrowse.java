package com.company.unicef.screen.needscare;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsCare;

@UiController("NeedsCare.browse")
@UiDescriptor("needs-care-browse.xml")
@LookupComponent("needsCaresTable")
public class NeedsCareBrowse extends StandardLookup<NeedsCare> {
}