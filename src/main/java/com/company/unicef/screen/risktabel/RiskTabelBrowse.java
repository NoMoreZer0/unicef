package com.company.unicef.screen.risktabel;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.RiskTabel;

@UiController("RiskTabel.browse")
@UiDescriptor("risk-tabel-browse.xml")
@LookupComponent("riskTabelsTable")
public class RiskTabelBrowse extends StandardLookup<RiskTabel> {
}