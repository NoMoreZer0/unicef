package com.company.unicef.screen.needseducation;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsEducation;

@UiController("NeedsEducation.edit")
@UiDescriptor("needs-education-edit.xml")
@EditedEntityContainer("needsEducationDc")
public class NeedsEducationEdit extends StandardEditor<NeedsEducation> {
}