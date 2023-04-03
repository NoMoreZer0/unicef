package com.company.unicef.screen.firstform;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.FirstForm;

@UiController("FirstForm.browse")
@UiDescriptor("first-form-browse.xml")
@LookupComponent("firstFormsTable")
public class FirstFormBrowse extends StandardLookup<FirstForm> {
}