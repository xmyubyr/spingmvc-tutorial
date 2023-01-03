package com.example.jindian.chapter8;

import java.util.ArrayList;
import java.util.List;

//8.4 幂集。编写一种方法，返回某集合的所有子集。解法回溯法（还需继续练习）
public class SubSets04 {
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        backtrack(0,list,new ArrayList<>(),nums);
        return list;

    }
    public static void backtrack(int start,List<List<Integer>> list,List<Integer> temp,int[] nums){
       list.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
           /* System.out.println("qian:"+temp);
            System.out.println("b:"+(i+1));*/
            backtrack(i+1,list,temp,nums);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }

}
