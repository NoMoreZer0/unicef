package com.company.unicef.screen.test;

import io.jmix.core.LoadContext;
import io.jmix.core.SaveContext;
import io.jmix.ui.screen.*;
import com.company.unicef.entity.Test;

import java.util.Collections;
import java.util.Set;

@UiController("Test.edit")
@UiDescriptor("test-edit.xml")
@EditedEntityContainer("testDc")
public class TestEdit extends StandardEditor<Test> {

    @Install(to = "testDl", target = Target.DATA_LOADER)
    private Test testDlLoadDelegate(LoadContext<Test> loadContext) {
        // Here you can load entity from an external store by ID passed in LoadContext
        return getEditedEntity();
    }

    @Install(target = Target.DATA_CONTEXT)
    private Set<Object> commitDelegate(SaveContext saveContext) {
        // Here you can save the edited entity or the whole SaveContext in an external store.
        // Return the set of saved instances.
        return Collections.singleton(getEditedEntity());
    }
}