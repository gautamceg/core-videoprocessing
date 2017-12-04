package com.vuclip.video.processing.validate;

import com.vuclip.video.processing.dto.*;

import java.util.Arrays;
import java.util.List;

public class AssetsGenreValidator implements Validator<AssetValidationContext> {

    private final static List<Genre> acceptedGenre =Arrays.asList(Genre.MOVIE,Genre.TV,Genre.SONG);

    public void validate(AssetValidationContext context) {
        if(!acceptedGenre.contains(context.getVideo().getGenre())){
            context.setValidationStatus(Boolean.FALSE);
            context.addFailureCause(FailureCause.GENRE);
            return;
        }
        context.setValidationStatus(Boolean.TRUE);
    }

}
