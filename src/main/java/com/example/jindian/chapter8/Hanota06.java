package com.example.jindian.chapter8;

import java.util.List;

//8.6 汉诺塔问题。在经典汉诺塔问题中，有3 根柱子及N 个不同大小的穿孔圆盘，盘子可
//以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上（即每一个盘
//子只能放在更大的盘子上面）。移动圆盘时受到以下限制：
//(1) 每次只能移动一个盘子；
//(2) 盘子只能从柱子顶端滑出移到下一根柱子；
//(3) 盘子只能叠在比它大的盘子上。
//请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
public class Hanota06 {
    public static void hanota(List<Integer> A,List<Integer> B,List<Integer> C){
        int N = A.size();
        move(N,A,B,C);
    }
    public static void move(int s,List<Integer> from,List<Integer> temp,List<Integer> dest){
        if (s == 1){
            dest.add(0,from.remove(0));
        }
        //System.out.println("标记为："+s+"号"+"的盘子，从"+from+"移动到"+dest);
        move(s-1,from,dest,temp);
        dest.add(0,from.remove(0));
        move(s-1,temp,from,dest);

    }

   /* public static void main(String[] args) {
        hanota();
    }*/
}
