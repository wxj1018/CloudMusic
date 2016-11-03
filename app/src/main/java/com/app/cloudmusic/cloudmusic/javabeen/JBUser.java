package com.app.cloudmusic.cloudmusic.javabeen;

/**
 * Created by yg on 2016/10/21.
 */
public class JBUser {
    private int uid;
    private String uname;
    private String upass;
    private String uimage;
    private String uunderwrite;
    private int umttypeid;
    private int usutypeid;


    public JBUser(int uid, String uname, String upass, String uimage, String uunderwrite, int umttypeid, int usutypeid) {
        this.uid = uid;
        this.uname = uname;
        this.upass = upass;
        this.uimage = uimage;
        this.uunderwrite = uunderwrite;
        this.umttypeid = umttypeid;
        this.usutypeid = usutypeid;
    }

    public int getUid() {
        return uid;
    }

    public int getUsutypeid() {
        return usutypeid;
    }

    public String getUname() {
        return uname;
    }

    public String getUpass() {
        return upass;
    }

    public String getUimage() {
        return uimage;
    }

    public String getUunderwrite() {
        return uunderwrite;
    }

    public int getUmttypeid() {
        return umttypeid;
    }
}
