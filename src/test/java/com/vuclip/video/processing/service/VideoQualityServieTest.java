package com.vuclip.video.processing.service;

import com.vuclip.video.processing.dto.AssetValidationContext;
import com.vuclip.video.processing.dto.Genre;
import com.vuclip.video.processing.dto.Language;
import com.vuclip.video.processing.dto.Video;
import com.vuclip.video.processing.validate.Validator;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class VideoQualityServieTest {

    private VideoQualityService videoQualityService;

    private ExecutorService pool;

    private List<Validator> validatorList;

    @Before
    public void setUp(){
        videoQualityService  = new  VideoQualityService();
    }

    @Ignore
    @Test
    public void test() throws InterruptedException {
        List<AssetValidationContext> assetValidationContexts = new ArrayList<>();
        Video video = new Video(45, Genre.MOVIE, Language.ENGLISH,123,"mp3");
        AssetValidationContext assetValidationContext = new AssetValidationContext(video);
        assetValidationContexts.add(assetValidationContext);
        videoQualityService.process(assetValidationContexts);
        Mockito.verify(pool, Mockito.times(1)).invokeAll(Matchers.any());
    }

}
