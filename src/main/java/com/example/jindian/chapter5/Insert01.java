package com.example.jindian.chapter5;
//插入。给定两个32 位的整数N 与M，以及表示比特位置的i 与j。编写一种方法，将
//M 插入N，使得M 从N 的第j 位开始，到第i 位结束。假定从j 位到i 位足以容纳M，也即若
//M = 10 011，那么j 和i 之间至少可容纳5 个位。例如，不可能出现j = 3 和i = 2 的情况，因为第
//3 位和第2 位之间放不下M。
//示例：
//输入：N = 10000000000, M = 10011, i = 2, j = 6
//输出：N = 10001001100
public class Insert01 {
    //解决这个问题可分为三大步骤。
    //(1) 将N 中从j 到i 之间的位清零。
    //(2) 对M执行移位操作，与j 和i 之间的位对齐。
    //(3) 合并M与N。
    //步骤(1)最为棘手。如何将N 中的那些位清零呢？我们可以利用掩码来清零。除j 到i 之间
    //的位为0 外，这个掩码的其余位均为1。我们会先创建掩码的左半部分，然后是右半部分，最
    //终得到整个掩码。
    public int updateBit(int m,int n,int i, int j){
        int allones = ~0;
        int left = allones <<(j+1);
        int right = (1 << i)-1;
        int mask = left | right;
        int nclear = n & mask;
        int mshifted = m << i;
        return nclear | mshifted;

    }

}
