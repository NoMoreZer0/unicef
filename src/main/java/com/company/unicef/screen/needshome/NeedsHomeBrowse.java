package com.company.unicef.screen.needshome;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsHome;

@UiController("NeedsHome.browse")
@UiDescriptor("needs-home-browse.xml")
@LookupComponent("needsHomesTable")
public class NeedsHomeBrowse extends StandardLookup<NeedsHome> {
}