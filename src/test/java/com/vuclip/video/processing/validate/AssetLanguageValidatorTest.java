package com.vuclip.video.processing.validate;

import com.vuclip.video.processing.dto.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AssetLanguageValidatorTest {


    private Validator  assetLanguageValidator;

    @Before
    public void setUp(){
        assetLanguageValidator = new AssetLanguageValidator();
    }

    @Test
    public void testWhenLanguageIsCorrect(){
        Video video = new Video(45, Genre.MOVIE, Language.ENGLISH,123,"mp3");
        AssetValidationContext assetValidationContext  = new AssetValidationContext(video);
        assetLanguageValidator.validate(assetValidationContext);
        Assert.assertTrue(assetValidationContext.isValidationStatus());
        Assert.assertFalse(assetValidationContext.getFailureCauses().contains(FailureCause.LANGUAGE));
    }

    @Test
    public void testWhenLanguageIsNotCorrect(){
        Video video = new Video(45, Genre.MOVIE, Language.TAMIL,123,"mp3");
        AssetValidationContext assetValidationContext  = new AssetValidationContext(video);
        assetLanguageValidator.validate(assetValidationContext);
        Assert.assertFalse(assetValidationContext.isValidationStatus());
        Assert.assertTrue(assetValidationContext.getFailureCauses().contains(FailureCause.LANGUAGE));
    }
}
