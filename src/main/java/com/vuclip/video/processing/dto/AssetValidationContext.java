package com.vuclip.video.processing.dto;

import java.util.ArrayList;
import java.util.List;

public class AssetValidationContext {

    private Video video;

    private Boolean validationStatus;

    private List<FailureCause> failureCauses;

    public Video getVideo() {
        return video;
    }

    public AssetValidationContext(Video video) {
        this.video = video;
        this.failureCauses = new ArrayList<>(FailureCause.values().length);
    }

    public void addFailureCause(FailureCause failureCause){
        this.failureCauses.add(failureCause);
    }

    public boolean isValidationStatus() {
        return validationStatus;
    }

    public List<FailureCause> getFailureCauses() {
        return failureCauses;
    }

    public void setValidationStatus(boolean validationStatus) {
        if(this.validationStatus!=null && !this.validationStatus){
            return;
        }
        this.validationStatus = validationStatus;
    }

    public void setFailureCauses(List<FailureCause> failureCause) {
        this.failureCauses = failureCause;
    }



    @Override
    public String toString() {
        return "AssetValidationContext{" +
                "video=" + video +
                ", validationStatus=" + validationStatus +
                ", failureCause=" + failureCauses +
                '}';
    }
}
