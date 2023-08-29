package com.company.unicef.screen.secondform;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.SecondForm;

@UiController("SecondForm.browse")
@UiDescriptor("second-form-browse.xml")
@LookupComponent("secondFormsTable")
public class SecondFormBrowse extends StandardLookup<SecondForm> {
}