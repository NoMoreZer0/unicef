package com.company.unicef.screen.needsself;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsSelf;

@UiController("NeedsSelf.browse")
@UiDescriptor("needs-self-browse.xml")
@LookupComponent("needsSelvesTable")
public class NeedsSelfBrowse extends StandardLookup<NeedsSelf> {
}