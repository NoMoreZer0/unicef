package com.company.unicef.screen.allfiles;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.AllFiles;

@UiController("AllFiles.edit")
@UiDescriptor("all-files-edit.xml")
@EditedEntityContainer("allFilesDc")
public class AllFilesEdit extends StandardEditor<AllFiles> {
}