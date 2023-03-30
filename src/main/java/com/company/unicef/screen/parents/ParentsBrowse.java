package com.company.unicef.screen.parents;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Parents;

@UiController("Parents.browse")
@UiDescriptor("parents-browse.xml")
@LookupComponent("parentsesTable")
public class ParentsBrowse extends StandardLookup<Parents> {
}