package com.app.cloudmusic.cloudmusic.Yuanzhongxue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/18 0018.
 */
public class LrcProgrocess {
    private List<LrcContent> lrcList;	//List集合存放歌词内容对象
    private LrcContent mLrcContent;		//声明一个歌词内容对象

    public LrcProgrocess() {
        mLrcContent = new LrcContent();
        lrcList = new ArrayList<>();
    }
    //读取歌曲
    public  String readLRC (String path){
        StringBuilder stringBuilder = new StringBuilder();
        File f = new File(path.replace(".mp3", ".lrc"));
        try {
            FileInputStream fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis,"utf-8");
            BufferedReader bufferedReader = new BufferedReader(isr);
            String s ="";
            while ((s=bufferedReader.readLine())!=null){
                s.replace("[","");
                s.replace("]","@");
                String splitLrcData[] = s.split("@");
                if(splitLrcData.length > 1) {
                    mLrcContent.setLrcStr(splitLrcData[1]);

                    //处理歌词取得歌曲的时间
                    int lrcTime = time2Str(splitLrcData[0]);

                    mLrcContent.setLrcTime(lrcTime);

                    //添加进列表数组
                    lrcList.add(mLrcContent);

                    //新创建歌词内容对象
                    mLrcContent = new LrcContent();
                }


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }catch (IOException e) {
            e.printStackTrace();
            stringBuilder.append("木有读取到歌词哦！");
        }

        return stringBuilder.toString();
    }

    private int time2Str(String timeStr) {
        timeStr = timeStr.replace(":", ".");
        timeStr = timeStr.replace(".", "@");

        String timeData[] = timeStr.split("@");	//将时间分隔成字符串数组

        //分离出分、秒并转换为整型
        int minute = Integer.parseInt(timeData[0]);
        int second = Integer.parseInt(timeData[1]);
        int millisecond = Integer.parseInt(timeData[2]);

        //计算上一行与下一行的时间转换为毫秒数
        int currentTime = (minute * 60 + second) * 1000 + millisecond * 10;
        return currentTime;

    }
    public List<LrcContent> getLrcList() {
        return lrcList;
    }

}
