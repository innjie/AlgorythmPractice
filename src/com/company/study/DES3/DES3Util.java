package com.company.study.DES3;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class DES3Util {
    public static void main(String[] args) {
        util();
    }
    private static Key key = null;

    static {
        if(key == null) {
            // Key 초기화
            KeyGenerator keyGenerator;
            try {
                keyGenerator = KeyGenerator.getInstance("TripleDES");
                keyGenerator.init(168);
                key = keyGenerator.generateKey();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

    public static String encrypt(String inStr) {
        StringBuffer sb = null;
        try {
            Cipher cipher = Cipher.getInstance("TripleDES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plaintext = inStr.getBytes("UTF8");
            byte[] ciphertext = cipher.doFinal(plaintext);

            sb = new StringBuffer(ciphertext.length * 2);
            for(int i = 0; i < ciphertext.length; i++) {
                String hex = "0" + Integer.toHexString(0xff & ciphertext[i]);
                sb.append(hex.substring(hex.length()-2));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String decrypt(String inStr) {
        String text = null;
        try {
            byte[] b = new byte[inStr.length()/2];
            Cipher cipher = Cipher.getInstance("TripleDES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            for(int i = 0; i < b.length; i++) {
                b[i] = (byte)Integer.parseInt(inStr.substring(2*i, 2*i+2), 16);
            }
            byte[] decryptedText = cipher.doFinal(b);
            text = new String(decryptedText,"UTF8");
        }catch(Exception e) {
            e.printStackTrace();
        }
        return text;
    }
    public static String util() {
        String str = "{'rid': '90', 'loginid' : 'innjie', 'pwd' : 'innjie1!'}";

        String des3_en = DES3Util.encrypt(str);
        String des3_de = DES3Util.decrypt(des3_en);

        System.out.println("3DES 암호화 : "+des3_en); //DES3 암호화
        System.out.println("3DES 복호화 : "+des3_de); //DES3 복호화
        return str;
    }
}
