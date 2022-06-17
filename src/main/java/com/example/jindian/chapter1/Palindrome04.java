package com.jindian.chapter1;

public class Palindrome04 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("aazbzaab"));
    }
    public static boolean isPalindrome(String s){
        int[] table = buildCharFrequencyTable(s);
        return checkMaxOneOdd(table);
    }
    //对字符出现的次数进行统计
    public static int[] buildCharFrequencyTable(String s){
        int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
        for(char a:s.toCharArray()){
            int x =getCharNumber(a);
            if(x!=-1){
                table[x]++;
            }
        }
        /*for(int i=0;i<table.length;i++){
            System.out.println(i+"--->"+table[i]);
        }*/

        return table;
    }
    //将每个字符对应为一个数字。a -> 0, b -> 1, c -> 2,等等。
    //不用区分大小写。非字母对应为-1
    public static int getCharNumber(char c){
        int z=Character.getNumericValue('z');
        int a=Character.getNumericValue('a');
        int value=Character.getNumericValue(c);
        if(a<=value && value <=z){
            return value -a;
        }
        return -1;
    }
    //检查最多一个字符的数目为奇数
    public static boolean checkMaxOneOdd(int[] table){
        boolean foundOdd =false;
        for(int t:table){
            if(t%2==1){
                if(foundOdd){
                   return false;
                }
                foundOdd =true;
            }
        }
        return true;

    }

}
