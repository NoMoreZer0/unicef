package com.company.unicef.screen.result;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Result;

@UiController("Result_.edit")
@UiDescriptor("result-edit.xml")
@EditedEntityContainer("resultDc")
public class ResultEdit extends StandardEditor<Result> {
}