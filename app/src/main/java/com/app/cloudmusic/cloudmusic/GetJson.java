package com.app.cloudmusic.cloudmusic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.app.cloudmusic.cloudmusic.javabeen.JBMtType;
import com.app.cloudmusic.cloudmusic.javabeen.JBUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;



/**
 * Created by yg on 2016/10/22.
 */
public class GetJson {

    final static String url = "http://192.168.56.1/cloudmusic2/getData.php?action=";
    public static String imagepath = "http://192.168.56.1/cloudmusic2/";






    public static String getJson(String tablename, String where, int size) {
        String result = "";
        try {
            URL mUrl = new URL(url + tablename + where);
            HttpURLConnection uc = (HttpURLConnection) mUrl.openConnection();
            uc.setRequestMethod("GET");
            InputStream is = uc.getInputStream();
            byte[] temp = new byte[size];
            is.read(temp);
            result = new String(temp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }

    public static ArrayList<JBMtType> getMttype(String result) {
        final ArrayList<JBMtType> list = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(result);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                int id = object.getInt("mtid");
                String name = object.getString("mtname");
                list.add(new JBMtType(id, name));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static ArrayList<JBUser> getUser(String result) {
        final ArrayList<JBUser> list = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(result);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                int uid = object.getInt("userid");
                String uname = object.getString("uname");
                String uimage = object.getString("uimage");
                String uunderwrite = object.getString("uunderwrite");
                String upass = object.getString("uimage");
                int umttypeid = object.getInt("umttypeid");
                int usutypeid = object.getInt("usutypeid");
                list.add(new JBUser(uid, uname, upass, uimage, uunderwrite, umttypeid, usutypeid));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
