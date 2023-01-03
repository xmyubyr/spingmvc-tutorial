package com.example.jindian.chapter5;
//5.3 翻转数位。给定一个整数，你可以将一个数位从0 变为1。请编写一个程序，找出你
//能够获得的最长的一串1 的长度。示例：
//输入：751（或者：10011101111）
//输出：8
public class LongestSequence03 {
    public static void main(String[] args) {
        System.out.println(slipBit(751));
    }
    public static int slipBit(int n){
        if(~ n == 0){
          return Integer.BYTES *8;
        }
        int currentLength =0;
        int previousLength =0;
        int maxLength =1;
        while(n!=0){
            if((n & 1) ==1){
                currentLength ++;
            }else {
                previousLength = (n & 2) == 0 ? 0: currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(previousLength+currentLength+1,maxLength);
            n >>>= 1;
        }
        return maxLength;
    }
}
