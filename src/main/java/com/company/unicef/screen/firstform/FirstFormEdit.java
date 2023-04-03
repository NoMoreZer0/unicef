package com.company.unicef.screen.firstform;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.FirstForm;

@UiController("FirstForm.edit")
@UiDescriptor("first-form-edit.xml")
@EditedEntityContainer("firstFormDc")
public class FirstFormEdit extends StandardEditor<FirstForm> {
}