package com.vuclip.video.processing.service;

import com.vuclip.video.processing.dto.AssetValidationContext;
import com.vuclip.video.processing.dto.Genre;
import com.vuclip.video.processing.dto.Language;
import com.vuclip.video.processing.dto.Video;
import com.vuclip.video.processing.validate.Validator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

public class VideoQualityValidatorExecutorTest {

    private  VideoQualityValidatorExecutor videoQualityValidatorExecutor;

    private List<AssetValidationContext> contextList;

    private List<Validator> validatorList;

    private  Validator validator;

    @Before
    public void setUp(){
        contextList = new ArrayList<>();
        validatorList = new ArrayList<>();
        validator= Mockito.mock(Validator.class);
        validatorList.add(validator);
        Video video = new Video(45, Genre.MOVIE, Language.ENGLISH,123,"mp3");
        AssetValidationContext assetValidationContext = new AssetValidationContext(video);
        contextList.add(assetValidationContext);
        videoQualityValidatorExecutor  = new VideoQualityValidatorExecutor(contextList,validatorList);
    }

    @Test
    public void test(){
        videoQualityValidatorExecutor.call();
        Mockito.verify(validator, Mockito.times(1)).validate(Matchers.any(AssetValidationContext.class));
    }


}
