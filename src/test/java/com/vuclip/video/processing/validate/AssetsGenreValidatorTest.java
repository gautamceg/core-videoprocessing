package com.vuclip.video.processing.validate;

import com.vuclip.video.processing.dto.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AssetsGenreValidatorTest {


    private Validator  assetsGenreValidator;

    @Before
    public void setUp(){
        assetsGenreValidator = new AssetsGenreValidator();
    }

    @Test
    public void testWhenGenreIsCorrect(){
        Video video = new Video(45, Genre.MOVIE, Language.ENGLISH,123,"mp3");
        AssetValidationContext assetValidationContext  = new AssetValidationContext(video);
        assetsGenreValidator.validate(assetValidationContext);
        Assert.assertTrue(assetValidationContext.isValidationStatus());
        Assert.assertFalse(assetValidationContext.getFailureCauses().contains(FailureCause.GENRE));
    }

    @Test
    public void testWhenGenreIsNotCorrect(){
        Video video = new Video(45, Genre.NEWS, Language.TAMIL,123,"mp3");
        AssetValidationContext assetValidationContext  = new AssetValidationContext(video);
        assetsGenreValidator.validate(assetValidationContext);
        Assert.assertFalse(assetValidationContext.isValidationStatus());
        Assert.assertTrue(assetValidationContext.getFailureCauses().contains(FailureCause.GENRE));
    }
}
