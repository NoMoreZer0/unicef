package com.company.unicef.screen.needsemotion;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsEmotion;

@UiController("NeedsEmotion.browse")
@UiDescriptor("needs-emotion-browse.xml")
@LookupComponent("needsEmotionsTable")
public class NeedsEmotionBrowse extends StandardLookup<NeedsEmotion> {
}