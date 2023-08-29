package com.company.unicef.screen.needsself;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsSelf;

@UiController("NeedsSelf.edit")
@UiDescriptor("needs-self-edit.xml")
@EditedEntityContainer("needsSelfDc")
public class NeedsSelfEdit extends StandardEditor<NeedsSelf> {
}