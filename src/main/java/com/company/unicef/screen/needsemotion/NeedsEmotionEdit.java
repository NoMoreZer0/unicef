package com.company.unicef.screen.needsemotion;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.NeedsEmotion;

@UiController("NeedsEmotion.edit")
@UiDescriptor("needs-emotion-edit.xml")
@EditedEntityContainer("needsEmotionDc")
public class NeedsEmotionEdit extends StandardEditor<NeedsEmotion> {
}