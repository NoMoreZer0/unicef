package com.company.unicef.screen.test;

import io.jmix.core.LoadContext;
import io.jmix.ui.screen.*;
import com.company.unicef.entity.Test;

import java.util.Collections;
import java.util.List;

@UiController("Test.browse")
@UiDescriptor("test-browse.xml")
@LookupComponent("testsTable")
public class TestBrowse extends StandardLookup<Test> {

    @Install(to = "testsDl", target = Target.DATA_LOADER)
    private List<Test> testsDlLoadDelegate(LoadContext<Test> loadContext) {
        // Here you can load entities from an external store
        return Collections.emptyList();
    }
}