package com.vuclip.video.processing.service;

import com.vuclip.video.processing.dto.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainClass {


    public  static  void main(String args[]) throws InterruptedException {
    List<Video> input = createTestInputVideosData();

        VideoQualityService videoQualityService = new VideoQualityService();
        List<AssetValidationContext> assetValidationContexts = input.stream().map(v->new AssetValidationContext(v)).collect(Collectors.toList());
        videoQualityService.process(assetValidationContexts);
        assetValidationContexts.stream().forEach(p->System.out.println(p));
        System.out.println("******* Video Quality Report stats ********");
        System.out.println("Videos in failed state: "+assetValidationContexts.stream().filter(c-> !c.isValidationStatus()).count());
        System.out.println("Videos in success state: "+assetValidationContexts.stream().filter(c-> c.isValidationStatus()).count());
        System.out.println("Videos failed because of language: "+assetValidationContexts.stream().filter(c-> c.getFailureCauses().contains(FailureCause.LANGUAGE)).count());
        System.out.println("Videos failed because of Genre: "+assetValidationContexts.stream().filter(c-> c.getFailureCauses().contains(FailureCause.GENRE)).count());
        System.out.println("Videos failed because of Video Quality: "+assetValidationContexts.stream().filter(c-> c.getFailureCauses().contains(FailureCause.VIDEO_QUALITY)).count());
    }

    private static List<Video> createTestInputVideosData() {
            List<Video> inputVideos = new ArrayList<Video>();
            Video video = new Video(45, Genre.MOVIE, Language.ENGLISH,123,"mp3");
            Video video2 = new Video(45,Genre.NEWS, Language.HINDI,40,"mp4");
            Video video3 = new Video(11,Genre.SONG, Language.KOREAN,40,"mp4");
            Video video4 = new Video(44,Genre.NEWS, Language.KOREAN,40,"mp4");
            Video video5 = new Video(44,Genre.NEWS, Language.TAMIL,40,"mp4");
            Video video6 = new Video(45, Genre.MOVIE, Language.ENGLISH,123,"mp3");
            inputVideos.addAll(Arrays.asList(video,video2,video3,video4,video5,video6));
            return inputVideos;
    }
}
