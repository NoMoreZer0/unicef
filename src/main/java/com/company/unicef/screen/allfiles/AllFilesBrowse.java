package com.company.unicef.screen.allfiles;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.AllFiles;

@UiController("AllFiles.browse")
@UiDescriptor("all-files-browse.xml")
@LookupComponent("allFilesesTable")
public class AllFilesBrowse extends StandardLookup<AllFiles> {
}