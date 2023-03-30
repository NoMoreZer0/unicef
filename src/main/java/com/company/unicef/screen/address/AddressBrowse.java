package com.company.unicef.screen.address;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Address;

@UiController("Address.browse")
@UiDescriptor("address-browse.xml")
@LookupComponent("addressesTable")
public class AddressBrowse extends StandardLookup<Address> {
}