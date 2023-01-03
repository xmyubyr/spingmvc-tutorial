package com.example.jindian.chapter8;
//8.5 递归乘法。写一个递归函数，不使用 * 运算符，实现两个正整数的相乘。可以使用加
//号、减号、位移，但要吝啬一些。
public class Multiply05 {
    public int multiply(int a,int b){
        int temp;
        if(a<b){
            temp = a;
            a = b;
            b = temp;
        }
        if(b > 0){
           return multiply(a,b-1)+a;
        }
        return 0;
    }
}
