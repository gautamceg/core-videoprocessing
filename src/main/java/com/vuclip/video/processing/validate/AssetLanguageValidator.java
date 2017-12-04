package com.vuclip.video.processing.validate;

import com.vuclip.video.processing.dto.AssetValidationContext;
import com.vuclip.video.processing.dto.FailureCause;
import com.vuclip.video.processing.dto.Language;
import com.vuclip.video.processing.dto.Video;

import java.util.Arrays;
import java.util.List;

public class AssetLanguageValidator implements Validator<AssetValidationContext> {

    private final static List<Language> acceptedLanguage =Arrays.asList(Language.ENGLISH,Language.HINDI,Language.KOREAN);

    public void  validate(AssetValidationContext context) {
        if(!acceptedLanguage.contains(context.getVideo().getLanguage())){
            context.setValidationStatus(Boolean.FALSE);
            context.addFailureCause(FailureCause.LANGUAGE);
            return;
        }
        context.setValidationStatus(Boolean.TRUE);
    }
}
