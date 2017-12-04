package com.vuclip.video.processing.validate;

import com.vuclip.video.processing.dto.AssetValidationContext;
import com.vuclip.video.processing.dto.FailureCause;
import com.vuclip.video.processing.dto.Video;

public class VideoQualityValidator implements Validator<AssetValidationContext> {

    public  void validate(AssetValidationContext context) {
        int frameRate = context.getVideo().getFrameRate();
        if (frameRate < 24 || frameRate > 128) {
            context.setValidationStatus(Boolean.FALSE);
            context.addFailureCause(FailureCause.VIDEO_QUALITY);
            return;
        }
        context.setValidationStatus(Boolean.TRUE);
    }
}
