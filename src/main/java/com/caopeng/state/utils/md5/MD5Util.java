package com.caopeng.state.utils.md5;

import java.math.BigInteger;
import java.security.MessageDigest;


public class MD5Util {
    public MD5Util() {
    }

    public static String md5(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes("UTF-8"));
            return bytesToHex(md5.digest());
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    public static String md5slat(String str){
        return MD5Util.md5(MD5Util.md5("jiangfujia"+str+"223920230823!!!"));
    }

    public static String bytesToHex(byte[] bytes) {
        BigInteger bigInt = new BigInteger(1, bytes);

        String hashtext;
        for(hashtext = bigInt.toString(16); hashtext.length() < 32; hashtext = "0" + hashtext) {
        }

        return hashtext;
    }
}
