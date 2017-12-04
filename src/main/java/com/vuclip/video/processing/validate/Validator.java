package com.vuclip.video.processing.validate;

import com.vuclip.video.processing.dto.Video;

public interface Validator<I> {

    public void validate(I input);
}
