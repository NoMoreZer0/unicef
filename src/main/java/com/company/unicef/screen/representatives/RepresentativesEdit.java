package com.company.unicef.screen.representatives;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Representatives;

@UiController("Representatives.edit")
@UiDescriptor("representatives-edit.xml")
@EditedEntityContainer("representativesDc")
public class RepresentativesEdit extends StandardEditor<Representatives> {
}