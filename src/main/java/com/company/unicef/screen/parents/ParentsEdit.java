package com.company.unicef.screen.parents;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Parents;

@UiController("Parents.edit")
@UiDescriptor("parents-edit.xml")
@EditedEntityContainer("parentsDc")
public class ParentsEdit extends StandardEditor<Parents> {
}