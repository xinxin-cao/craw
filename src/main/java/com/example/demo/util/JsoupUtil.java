package com.example.demo.util;

import org.jsoup.Jsoup;

/**
 * @author caoyaxin
 * @date 2019-10-14-17:02
 */
public class JsoupUtil {

    public static String getUrl(String url){
        String html = "";
        try{
            html = Jsoup.connect(url).cookie("SAMPLE-SESSIONID","022f2802-b161-4b62-bdd8-44db166a0086").get().html();
        }catch (Exception e){
            e.printStackTrace();
        }
        return html;
    }
}
