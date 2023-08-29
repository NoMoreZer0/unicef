package com.company.unicef.screen.needseducation;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsEducation;

@UiController("NeedsEducation.browse")
@UiDescriptor("needs-education-browse.xml")
@LookupComponent("needsEducationsTable")
public class NeedsEducationBrowse extends StandardLookup<NeedsEducation> {
}