package com.company.unicef.screen.result;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Result;

@UiController("Result_.browse")
@UiDescriptor("result-browse.xml")
@LookupComponent("resultsTable")
public class ResultBrowse extends StandardLookup<Result> {
}