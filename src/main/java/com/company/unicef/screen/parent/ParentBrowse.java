package com.company.unicef.screen.parent;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Parent;

@UiController("Parent.browse")
@UiDescriptor("parent-browse.xml")
@LookupComponent("parentsTable")
public class ParentBrowse extends StandardLookup<Parent> {
}