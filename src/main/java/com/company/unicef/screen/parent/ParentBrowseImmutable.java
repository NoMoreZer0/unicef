package com.company.unicef.screen.parent;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Parent;

@UiController("Parent.browse.immutable")
@UiDescriptor("parent-browse-immutable.xml")
@LookupComponent("parentsTable")
public class ParentBrowseImmutable extends StandardLookup<Parent> {
}