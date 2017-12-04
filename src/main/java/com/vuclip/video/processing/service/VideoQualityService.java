package com.vuclip.video.processing.service;

import com.google.common.collect.Lists;
import com.vuclip.video.processing.dto.AssetValidationContext;
import com.vuclip.video.processing.dto.Video;
import com.vuclip.video.processing.validate.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class VideoQualityService {

    private ExecutorService pool;

    private List<Validator> validatorList;

    VideoQualityService(){
        pool = Executors.newFixedThreadPool(4);
        validatorList =ValidatorsConfig.getValidators();
    }

    public void process(List<AssetValidationContext> assetValidationContexts) throws InterruptedException {
        List<List<AssetValidationContext>> videosLists = Lists.partition(assetValidationContexts,4);
        final List<Callable<Integer>> tasks = new ArrayList<>(videosLists.size());





        videosLists.stream().forEach(l->tasks.add(new VideoQualityValidatorExecutor(l,validatorList)));

        final List<Future<Integer>> partialResults =pool.invokeAll(tasks);
        partialResults.get(0);

    }

}
