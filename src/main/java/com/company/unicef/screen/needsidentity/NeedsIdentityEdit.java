package com.company.unicef.screen.needsidentity;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsIdentity;

@UiController("NeedsIdentity.edit")
@UiDescriptor("needs-identity-edit.xml")
@EditedEntityContainer("needsIdentityDc")
public class NeedsIdentityEdit extends StandardEditor<NeedsIdentity> {
}