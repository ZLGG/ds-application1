package com.zlg.bs.user.util;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class UuidUtil {
    public static final String SOURCES =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

    public static String generateString(Random random, String characters ,int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }

    public static String generateString1() {
        char[] text = new char[13];
        Random random = new Random();
        for (int i = 0; i < 13; i++) {
            text[i] = SOURCES.charAt(random.nextInt(SOURCES.length()));
        }
        return "my_"+new String(text);
    }

    public static String getOrderNo() {
        String orderNo = "";
        UUID uuid = UUID.randomUUID();
        String trandNo = String.valueOf((Math.random() * 9 + 1) * 1000000);
        String sdf = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());
        orderNo = uuid.toString().substring(0, 8);
        orderNo = orderNo + sdf;
        return orderNo;
    }

//生成19随机单号 纯数字


    public static String getOrderNo1() {
        String orderNo = "";
        String trandNo = String.valueOf((Math.random() * 9 + 1) * 1000000);
        String sdf = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());
        System.out.println(sdf);
        orderNo = trandNo.toString().substring(0, 4);
        orderNo = orderNo + sdf;
        return orderNo;
    }


}
