package com.example.jindian.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//8.8 重复字符串的排列组合。编写一种方法，计算字符串所有的排列组合，字符串中可能
//有字符相同，但结果不能有重复组合。
public class PermutationDuplicate08 {
    static List<String> strings = new ArrayList<>();
    public static List<String> permut(String s){
        if(s==null && s.length() == 0){
            return null;
        }
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int[] isUsed = new int[9];
        backtrack(sb,arr,isUsed);
        return strings;
    }
    public static void backtrack(StringBuilder sb,char[] arr,int[] isUsed){
        if(arr.length == sb.length()){
            strings.add(sb.toString());
            return;
        }
        char temp = ' ';
        for(int i=0;i<arr.length;i++){
            //相同的字符在同一层直接不执行
            if(temp == arr[i] ||isUsed[i] == 1){
               continue;
            }
            temp = arr[i];
            sb.append(arr[i]);
            isUsed[i]=1;
            backtrack(sb,arr,isUsed);
            sb.deleteCharAt(sb.length()-1);
            isUsed[i]=0;
        }
    }
    public static void main(String[] args) {
        String s = "qqe";
        System.out.println(permut(s));
    }
}
