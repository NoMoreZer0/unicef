package com.company.unicef.screen.risktabel;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.RiskTabel;

@UiController("RiskTabel.edit")
@UiDescriptor("risk-tabel-edit.xml")
@EditedEntityContainer("riskTabelDc")
public class RiskTabelEdit extends StandardEditor<RiskTabel> {
}