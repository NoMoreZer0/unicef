package com.company.unicef.screen.relative;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Relative;

@UiController("Relative_.browse")
@UiDescriptor("relative-browse.xml")
@LookupComponent("relativesTable")
public class RelativeBrowse extends StandardLookup<Relative> {
}