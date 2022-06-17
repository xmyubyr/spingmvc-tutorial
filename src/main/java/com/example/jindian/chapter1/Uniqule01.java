package com.jindian.chapter1;
//判定字符是否唯一。实现一个算法，确定一个字符串的所有字符是否全都不同。假使不
//允许使用额外的数据结构，又该如何处理？（提示：#44，#117，#132）
public class Uniqule01 {
    public static void main(String[] args) {
        System.out.println(isUniquleStr("1c67809a1"));
    }
    public static boolean isUniqule(String s){
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isUniquleStr(String s){
        if(s.length()>128){
            return false;
        }
        boolean[] isUniqule = new boolean[128];
        for(int i=0;i<s.length();i++){
            if(isUniqule[s.charAt(i)]){
                return false;
            }
            isUniqule[s.charAt(i)]= true;
        }
        return true;
    }

}
