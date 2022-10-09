package com.company.study.DES3;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;

public class DES3Ex2 {
    public static void main(String[] args) throws Exception {
        String text = "javaScript";
        String encrypted = encrypt(text);
        String decrypted = decrypt(encrypted);

        System.out.println("Origin key: " + key());
        System.out.println("Origin key: " + text);
        System.out.println("Encrypted : " + encrypted);
        System.out.println("Decrypted : " + decrypted);
    }

    /**
     * 고정키 정보
     */
    public static String key() {
        return "ab_booktv_abcd09";
    }

    /**
     * 키값
     * 24byte인 경우 triple des 또는 des
     */
    public static Key getkey() throws Exception {
        return getKeyOf3DES(key());
    }

    /**
     * 비밀키
     */
    public static Key getKeyOf3DES(String keyValue) throws Exception {
        DESedeKeySpec desKeySpec = new DESedeKeySpec(keyValue.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        Key key = keyFactory.generateSecret(desKeySpec);
        return key;
    }

    /**
     * 문자열 대칭 암호화
     *
     * @param ID 비밀키 암호화를 희망하는 문자열
     * @return String 암호화된 ID
     * @throws Exception
     */
    public static String encrypt(String ID) throws Exception {
        if (ID == null || ID.length() == 0)
            return "";

        String instance = (key().length() == 24) ? "DESede/ECB/PKCS5Padding" : "DES/ECB/PKCS5Padding";
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(instance);
        cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, getKey());
        String amalgam = ID;

        byte[] inputBytes1 = amalgam.getBytes("UTF8");
        byte[] outputBytes1 = cipher.doFinal(inputBytes1);
        sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
        String outputStr1 = encoder.encode(outputBytes1);
        return outputStr1;
    }

    /**
     * 문자열 대칭 복호화
     *
     * @param codedID 비밀키 복호화를 희망하는 문자열
     * @return String 복호화된 ID
     * @throws Exception
     */
    public static String decrypt(String codedID) throws Exception {
        if (codedID == null || codedID.length() == 0)
            return "";

        String instance = (key().length() == 24) ? "DESede/ECB/PKCS5Padding" : "DES/ECB/PKCS5Padding";
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(instance);
        cipher.init(javax.crypto.Cipher.DECRYPT_MODE, getKey());
        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();

        byte[] inputBytes1 = decoder.decodeBuffer(codedID);
        byte[] outputBytes2 = cipher.doFinal(inputBytes1);

        String strResult = new String(outputBytes2, "UTF8");
        return strResult;
    }
}
