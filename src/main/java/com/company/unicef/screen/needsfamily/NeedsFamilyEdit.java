package com.company.unicef.screen.needsfamily;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsFamily;

@UiController("NeedsFamily.edit")
@UiDescriptor("needs-family-edit.xml")
@EditedEntityContainer("needsFamilyDc")
public class NeedsFamilyEdit extends StandardEditor<NeedsFamily> {
}