package com.company.unicef.screen.neednames;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedNames;

@UiController("NeedNames.edit")
@UiDescriptor("need-names-edit.xml")
@EditedEntityContainer("needNamesDc")
public class NeedNamesEdit extends StandardEditor<NeedNames> {
}