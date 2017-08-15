package com.utils;

import java.util.UUID;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-04-19 下午2:21
 */
public class UUIDGenerateUtil {

    public static String uuidGenerater() {

        String s = UUID.randomUUID().toString();
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);

    }

    public static void main(String[] args) {
        System.out.println(uuidGenerater());
    }
}
