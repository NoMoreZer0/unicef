package com.company.unicef.screen.needsidentity;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsIdentity;

@UiController("NeedsIdentity.browse")
@UiDescriptor("needs-identity-browse.xml")
@LookupComponent("needsIdentitiesTable")
public class NeedsIdentityBrowse extends StandardLookup<NeedsIdentity> {
}