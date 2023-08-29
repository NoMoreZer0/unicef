package com.company.unicef.screen.opencase;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.OpenCase;

@UiController("OpenCase.browse")
@UiDescriptor("open-case-browse.xml")
@LookupComponent("openCasesTable")
public class OpenCaseBrowse extends StandardLookup<OpenCase> {
}