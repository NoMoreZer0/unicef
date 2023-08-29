package com.company.unicef.screen.parent;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Parent;

@UiController("Parent.edit")
@UiDescriptor("parent-edit.xml")
@EditedEntityContainer("parentDc")
public class ParentEdit extends StandardEditor<Parent> {
}