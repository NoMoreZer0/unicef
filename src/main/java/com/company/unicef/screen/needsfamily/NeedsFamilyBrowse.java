package com.company.unicef.screen.needsfamily;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsFamily;

@UiController("NeedsFamily.browse")
@UiDescriptor("needs-family-browse.xml")
@LookupComponent("needsFamiliesTable")
public class NeedsFamilyBrowse extends StandardLookup<NeedsFamily> {
}