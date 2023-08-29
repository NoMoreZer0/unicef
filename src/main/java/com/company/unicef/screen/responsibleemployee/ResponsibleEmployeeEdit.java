package com.company.unicef.screen.responsibleemployee;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.ResponsibleEmployee;

@UiController("ResponsibleEmployee.edit")
@UiDescriptor("responsible-employee-edit.xml")
@EditedEntityContainer("responsibleEmployeeDc")
public class ResponsibleEmployeeEdit extends StandardEditor<ResponsibleEmployee> {
}