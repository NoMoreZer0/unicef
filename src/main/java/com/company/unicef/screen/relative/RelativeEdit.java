package com.company.unicef.screen.relative;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Relative;

@UiController("Relative_.edit")
@UiDescriptor("relative-edit.xml")
@EditedEntityContainer("relativeDc")
public class RelativeEdit extends StandardEditor<Relative> {
}