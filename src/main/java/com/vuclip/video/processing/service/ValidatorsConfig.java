package com.vuclip.video.processing.service;

import com.vuclip.video.processing.validate.AssetLanguageValidator;
import com.vuclip.video.processing.validate.AssetsGenreValidator;
import com.vuclip.video.processing.validate.Validator;
import com.vuclip.video.processing.validate.VideoQualityValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ValidatorsConfig {

    private static  List<Validator> validators = new ArrayList<>();

    static {
        Validator assetLanguageValidator = new AssetLanguageValidator();
        Validator assetsGenreValidator = new AssetsGenreValidator();
        Validator videoQualityValidator = new VideoQualityValidator();
        validators.addAll(Arrays.asList(assetLanguageValidator,assetsGenreValidator,videoQualityValidator));
    }

    public static List<Validator> getValidators(){
        return Collections.unmodifiableList(validators);
    }
}
