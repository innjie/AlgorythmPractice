package com.company.study.DES3;


import netscape.javascript.JSException;
import netscape.javascript.JSObject;

public class Test {
    Test() {
    }
    public static void main(String[] args) throws Exception {
        byte[] plane = "{'rid':'90', 'loginid : innjie', 'pwd' : 'innjie1!'".getBytes();
        byte[] keys = stringToHex("ssopublickey").getBytes();

        System.out.print("encrypted : ");
        System.out.println(Encryption_TripleDES(plane, keys));


    }
    public static String stringToHex(String str) {
        String appendValue = "";

        StringBuffer sbuf = new StringBuffer();
        for(int i=0; i< str.length(); i++){
            sbuf.append( "0x" + Integer.toHexString(str.charAt(i)) );
        }
        appendValue = sbuf.toString();
        return appendValue;
    }

    public static byte[] Encryption_TripleDES(byte[] plain, byte[] key) throws Exception {

        TripleDES Tdes = new TripleDES(key);
        return Tdes.encrypt(plain);
    }

    public byte[] Decryption_TripleDES(byte[] cipher, byte[] key) throws Exception {
        TripleDES Tdes = new TripleDES(key);
        return Tdes.decrypt(cipher);
    }
}
