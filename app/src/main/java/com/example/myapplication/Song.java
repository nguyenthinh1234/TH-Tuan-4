package com.example.myapplication;

import java.io.Serializable;

public class Song implements Serializable {
    private int resourceSong;
    private int imgSinger;
    private String nameSong;
    private String nameSinger;
    private int backgroundSong;
    private String timeSong;

    public Song(int resourceSong, int imgSinger, String nameSong, String nameSinger, int backgroundSong, String timeSong) {
        this.resourceSong = resourceSong;
        this.imgSinger = imgSinger;
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.backgroundSong = backgroundSong;
        this.timeSong = timeSong;
    }
    public Song(int resourceSong, int imgSinger, String nameSong, String nameSinger, int backgroundSong) {
        this.resourceSong = resourceSong;
        this.imgSinger = imgSinger;
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.backgroundSong = backgroundSong;

    }
    public int getResourceSong() {
        return resourceSong;
    }

    public void setResourceSong(int resourceSong) {
        this.resourceSong = resourceSong;
    }

    public int getImgSinger() {
        return imgSinger;
    }

    public void setImgSinger(int imgSinger) {
        this.imgSinger = imgSinger;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public int getBackgroundSong() {
        return backgroundSong;
    }

    public void setBackgroundSong(int backgroundSong) {
        this.backgroundSong = backgroundSong;
    }

    public String getTimeSong() {
        return timeSong;
    }

    public void setTimeSong(String timeSong) {
        this.timeSong = timeSong;
    }
}
