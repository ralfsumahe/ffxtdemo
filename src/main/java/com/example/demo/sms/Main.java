package com.example.demo.sms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author linkun
 * @date 2021/12/30 15:22
 */
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        dayin("20211230165300", "IMS_FAST_FINISH", "770427", "Fxft_2021");
        System.out.println("=============");
        dayin("20211230165300", "SmsSendByTemplet", "770427", "Fxft_2021");
    }

    public static void dayin(String timestamp, String methodName, String spid, String password) throws NoSuchAlgorithmException {
        System.out.println("password:" + getPassword(password));
        System.out.println("authenticator:" + getAuthenticator(timestamp, methodName, spid, getPassword(password)));
    }


    static String getPassword(String passwd) throws NoSuchAlgorithmException {
        return sha1Encrypt(passwd);
    }

    static String getAuthenticator(String timestamp, String methodName, String spid, String passwd) throws NoSuchAlgorithmException {
        return sha1Encrypt(timestamp + methodName + spid + passwd);
    }


    public static String sha1Encrypt(String str) throws NoSuchAlgorithmException {
        MessageDigest alg = MessageDigest.getInstance("SHA-1");
        alg.update(str.getBytes());
        byte[] bts = alg.digest();
        String result = "";
        String tmp = "";
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) result += "0";
            result += tmp;
        }
        return result;
    }


}
