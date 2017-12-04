package com.vuclip.video.processing.dto;

public enum Genre {

    MOVIE ("movie"),
    SONG ("song"),
    TV ("tv"),
    SERIES ("series"),
    NEWS ("news");

    private String name;

    Genre(String name){
        this.name=name;
    }
}
