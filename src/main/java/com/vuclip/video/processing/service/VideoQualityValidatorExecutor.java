package com.vuclip.video.processing.service;

import com.vuclip.video.processing.dto.AssetValidationContext;
import com.vuclip.video.processing.validate.Validator;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class VideoQualityValidatorExecutor implements Callable<Integer> {

    private List<AssetValidationContext> contextList;

    private List<Validator> validatorList;

    public VideoQualityValidatorExecutor(List<AssetValidationContext> contextList, List<Validator> validatorList) {
        this.contextList = Collections.unmodifiableList(contextList);
        this.validatorList = Collections.unmodifiableList(validatorList);
    }

    public Integer call() {
        for (final AssetValidationContext context : contextList) {
            validatorList.stream().forEach(v -> v.validate(context));
        }
        return 1;
    }
}
