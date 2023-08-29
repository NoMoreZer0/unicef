package com.company.unicef.screen.responsibleemployee;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.ResponsibleEmployee;

@UiController("ResponsibleEmployee.browse")
@UiDescriptor("responsible-employee-browse.xml")
@LookupComponent("responsibleEmployeesTable")
public class ResponsibleEmployeeBrowse extends StandardLookup<ResponsibleEmployee> {
}