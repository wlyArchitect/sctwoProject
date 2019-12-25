package com.wh.sys.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RandomUtil {
    /**
     * 年月日
     */
    private static SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 年月日 时分秒毫秒
     */
    private static SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static Random random=new Random();

    /**
     * 得到当前日期 (生成文件夹名称)
     */
    public static String getCurrentDateForString() {
        return sdf1.format(new Date());
    }

    /**
     * 1.生成文件名
     * 使用时间+4位随机数
     * @param
     */
    public static String createFileNameUseTime(String fileName) {
        //文件后缀 .png
        String fileSuffix=fileName.substring(fileName.lastIndexOf("."),fileName.length());
        //时间字符串
        String time=sdf2.format(new Date());
        //4位随机数
        Integer num=random.nextInt(9000)+1000;
        return time+num+fileSuffix;
    }

    /**
     * 2.生成文件名
     * 使用UUID
     * @param
     */
    public static String createFileNameUseUUID(String fileName) {
        String fileSuffix=fileName.substring(fileName.lastIndexOf("."),fileName.length());
        return UUID.randomUUID().toString().replace("-", "").toUpperCase()+fileSuffix;
    }

}
