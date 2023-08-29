package com.company.unicef.screen.secondformcheckbox;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.SecondFormCheckBox;

@UiController("SecondFormCheckBox.browse")
@UiDescriptor("second-form-check-box-browse.xml")
@LookupComponent("secondFormCheckBoxesTable")
public class SecondFormCheckBoxBrowse extends StandardLookup<SecondFormCheckBox> {
}