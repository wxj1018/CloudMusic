package com.app.cloudmusic.cloudmusic.javabeen;

/**
 * Created by yg on 2016/10/21.
 */
public class JBDynamic {
    private int id,userid;
    private String message,img;
    private int musicId,critique,crticism,relay;

    public JBDynamic(int id, int userid, String message, String img, int musicId, int critique, int crticism, int relay) {
        this.id = id;
        this.userid = userid;
        this.message = message;
        this.img = img;
        this.musicId = musicId;
        this.critique = critique;
        this.crticism = crticism;
        this.relay = relay;
    }

    public int getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }

    public String getMessage() {
        return message;
    }

    public String getImg() {
        return img;
    }

    public int getMusicId() {
        return musicId;
    }

    public int getCritique() {
        return critique;
    }

    public int getCrticism() {
        return crticism;
    }

    public int getRelay() {
        return relay;
    }
}
