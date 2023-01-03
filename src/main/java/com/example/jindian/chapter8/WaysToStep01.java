package com.example.jindian.chapter8;
//8.1 三步问题。有个小孩正在上楼梯，楼梯有n 阶台阶，小孩一次可以上1 阶、2 阶或3
//阶。实现一种方法，计算小孩有多少种上楼梯的方式。
public class WaysToStep01 {
    public int countWays(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n == 3){
            return 4;
        }
        long dp1=1;
        long dp2=2;
        long dp3=3;
        long A = 1000000007;
        for(int i=4;i<n;i++){
           long temp =dp1;
           dp1 = dp2;
           dp2 = dp3;
           dp3 =(temp+dp1+dp2) % A;
        }
        return (int)dp3;
    }
}
