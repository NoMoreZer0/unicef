package com.company.unicef.screen.representatives;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Representatives;

@UiController("Representatives.browse")
@UiDescriptor("representatives-browse.xml")
@LookupComponent("representativesesTable")
public class RepresentativesBrowse extends StandardLookup<Representatives> {
}