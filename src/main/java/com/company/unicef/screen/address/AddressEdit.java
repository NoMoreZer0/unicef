package com.company.unicef.screen.address;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Address;

@UiController("Address.edit")
@UiDescriptor("address-edit.xml")
@EditedEntityContainer("addressDc")
public class AddressEdit extends StandardEditor<Address> {
}