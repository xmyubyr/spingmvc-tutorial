package com.example.jindian.chapter5;
//5.6 整数转换。编写一个函数，确定需要改变几个位才能将整数A 转成整数B。
//示例：
//输入：29 (或者：11101), 15 (或者：01111)
//输出：2
public class IntegerSwap06 {
    //在异或操作的结果中，每个1 代表A 和B 相应位不同。因此，要找出A 和B 有多少个不同
    //的位，只要数一数A^B 有几个位为1。
    public int bitSwapReqired(int a,int b){
        int count =0;
        for(int c = a ^ b;c !=0;c = c >>>1){
            count += c & 1;
        }
        return count;
    }
}
