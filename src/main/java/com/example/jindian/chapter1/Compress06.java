package com.jindian.chapter1;
/*字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
        比如，字符串aabcccccaaa 会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先
        的字符串。你可以假设字符串中只包含大小写英文字母（a 至z）。*/
public class Compress06 {
    public static void main(String[] args) {
       // System.out.println(compress("aabc"));
        String s ="abc";
        if(s.contains(null)){
            System.out.println("=======");
        }
    }
    public static String compress(String s){
        StringBuilder bl= new StringBuilder();
        int count =0;
        for(int i=0;i<s.length();i++){
           count++;
            if(i+1>=s.length() || s.charAt(i)!=s.charAt(i+1)){
               bl.append(s.charAt(i));
               bl.append(count);
               count =0;
            }
        }
        return bl.length()>=s.length() ? s:bl.toString();
    }
}
