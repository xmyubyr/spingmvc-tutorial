package com.example.tutorial;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        List<Integer> list2 = new ArrayList<>();
        //删除不掉重复的3，因为执行了remove以后，index会自动-1，那么index+1的那个值就会变成index,而这个index已经执行过了。
        // 所以重复的数字如果相邻的删除一个，一定不能删掉
        /*for (int i=0;i<list.size();i++){
            if(list.get(i) == 3){
                list.remove(i);
            }
        }*/
        //如果把index同步-1了，那么就正常了。
        /*for (int i=0;i<list.size();i++){
            if(list.get(i) == 3){
                list.remove(i--);
            }
        }*/
        //ArrayList定义了一个内部类Iterator,在next和remove方法中都会调用checkforComodification方法，
        // 该方法判断modCount!=expectedModCount是否相等，如果不相等就抛出ConcurrentModificationException。
       /* for (Integer i:list){
            if(list.get(i) == 3){
                list.remove(i);
            }
        }*/
        /*list2.add(0,list.remove(0));
        System.out.println(list2);*/
        String securetoken = "base";
        String encode = Base64.encodeBase64String(md5(StringUtils.getBytesUtf8(securetoken)));
        System.out.println(Base64.encodeBase64String(md5(StringUtils.getBytesUtf8(securetoken))));
        System.out.println(Base64.decodeBase64(encode).toString());
    }
    public static byte[] md5(byte[] data) {
        return getMd5Digest().digest(data);
    }
    public static MessageDigest getMd5Digest() {
        return getDigest("MD5");
    }
    public static MessageDigest getDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException var2) {
            throw new IllegalArgumentException(var2);
        }
    }
}
