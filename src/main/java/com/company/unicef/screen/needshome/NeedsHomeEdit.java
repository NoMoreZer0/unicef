package com.company.unicef.screen.needshome;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsHome;

@UiController("NeedsHome.edit")
@UiDescriptor("needs-home-edit.xml")
@EditedEntityContainer("needsHomeDc")
public class NeedsHomeEdit extends StandardEditor<NeedsHome> {
}