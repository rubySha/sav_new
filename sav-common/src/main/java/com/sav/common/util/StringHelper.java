package com.sav.common.util;

/**
 * Created by kaikai on 2018/1/14.
 */
public class StringHelper {

    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }
}
