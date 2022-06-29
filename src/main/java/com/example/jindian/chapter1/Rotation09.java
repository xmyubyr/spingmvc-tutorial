package com.example.jindian.chapter1;
//1.9 字符串轮转。假定有一种isSubstring 方法，可检查一个单词是否为其他字符串的
//子串。给定两个字符串s1 和s2，请编写代码检查s2 是否为s1 旋转而成，要求只能调用一次
//isSubstring（比如，waterbottle 是erbottlewat 旋转后的字符串）。
public class Rotation09 {
    public static void main(String[] args) {

    }
    public static boolean isRotation(String s1, String s2){
        if(s1.length() == s2.length() && s1.length()>0){
            String s1s1 = s1+s1;
            return isSubstring(s1s1,s2);
        }
        return false;
    }
    public static boolean isSubstring(String s1,String s2){
        if(s1.contains(s2)){
            return true;
        }
        return false;
    }
}
