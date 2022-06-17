package com.jindian.chapter1;

import java.util.Arrays;
//判定是否互为字符重排。给定两个字符串，请编写程序，确定其中一个字符串的字符重
//新排列后，能否变成另一个字符串。（提示：#1，#84，#122，#131）
public class ReOrder02 {
    public static void main(String[] args) {
        System.out.println(permutation("ciue","iuec"));
    }
    public static boolean permutation(String s1,String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        return sort(s1).equals(sort(s2));
    }
    public static String sort(String s){
        char[] chars =s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
