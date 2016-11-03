package com.app.cloudmusic.cloudmusic.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/10/14 0014.
 */
public class CloudMusicOpenDB extends SQLiteOpenHelper {


    /**
     * user建表语句
     */
    public static final String CREATE_USER = "create table user ( id integer primary key autoincrement," +
            "user_account text,user_password integer)";

    /**
     * singer建表语句
     */
    public static final String CREATE_SINGER = "create table singer(id integer primary key autoincrement," +
            "singer_name text,sex text,country text,album text,mv text)";

    /**
     * music建表语句
     */
    public static final String CREATE_MUSIC = "create table music(id integer primary key autoincrement," +
            "music_name text,music_lyrics text,music_long integer,singer_info text)";

    /**
     * 构造器
     *
     * @param context
     * @param name
     * @param factory
     * @param version
     */

    public CloudMusicOpenDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_SINGER);
        db.execSQL(CREATE_MUSIC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
