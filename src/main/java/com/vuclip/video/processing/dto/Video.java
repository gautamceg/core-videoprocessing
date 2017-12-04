package com.vuclip.video.processing.dto;

public class Video {

    private int frameRate;
    private Genre genre;
    private Language language;
    private int duration;
    private String format;

    public Video(int frameRate, Genre genre, Language language, int duration, String format) {
        this.frameRate = frameRate;
        this.genre = genre;
        this.language = language;
        this.duration = duration;
        this.format = format;
    }

    public int getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Video{" +
                "frameRate=" + frameRate +
                ", genre='" + genre + '\'' +
                ", language=" + language +
                ", duration=" + duration +
                ", format='" + format + '\'' +
                '}';
    }
}
