package com.company.study.DES3;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;


public class DES3Ex3 {
    private KeySpec keySpec;
    private static SecretKey key;
    private static IvParameterSpec iv;
    private static String password = "{'rid':'90', 'loginid : innjie', 'pwd' : 'innjie1!'";
    public DES3Ex3(String keyString, String ivString) {
        try {
            keySpec = new DESKeySpec(password.getBytes("utf-8"));

            key = SecretKeyFactory.getInstance("DES").generateSecret(keySpec);


            iv = new IvParameterSpec(ivString.getBytes());

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println(encrypt(password));
    }
    public static String encrypt(String value) {
        try {
            Cipher ecipher = Cipher.getInstance("DESede/CBC/PKCS5Padding","SunJCE");
            Cipher.getInstance("DES/CFB/NoPadding","SunJCE");
            ecipher.init(Cipher.ENCRYPT_MODE, key, iv);

            if(value==null)
                return null;

            // Encode the string into bytes using utf-8
            byte[] utf8 = value.getBytes("UTF8");

            // Encrypt
            byte[] enc = ecipher.doFinal(utf8);

            // Encode bytes to base64 to get a string
            return new String(Base64.getEncoder().encode(enc),"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}