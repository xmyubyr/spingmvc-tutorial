package com.example.jindian.chapter5;
//5.7 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也
//就是说，位0 与位1 交换，位2 与位3 交换，以此类推）。
public class SwapOdd07 {
    public int swapOddEvenBits(int x){
        return  ((x & 0xaaaaaaaa)>>>1) | ((x & 0x5555555) <<1);
    }
}
