package com.app.cloudmusic.cloudmusic.model;

/**
 * Created by Administrator on 2016/10/14 0014.
 */
public class Music {

    private int id;
    private String music_name;
    private String lyrics;
    private int music_long;
    private String singer_info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public int getMusic_long() {
        return music_long;
    }

    public void setMusic_long(int music_long) {
        this.music_long = music_long;
    }

    public String getSinger_info() {
        return singer_info;
    }

    public void setSinger_info(String singer_info) {
        this.singer_info = singer_info;
    }
}
