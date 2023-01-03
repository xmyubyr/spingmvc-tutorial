package com.example.jindian.chapter8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//8.7 无重复数组的排列组合。编写一种方法，计算某数组的所有排列组合，数组每
//个字符均不相同。
public class Permutation07 {
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permut(int nums[]){
        List<Integer> track =new ArrayList<>();
        backtrack(nums,track);
        return res;
    }
    public static void backtrack(int nums[],List<Integer> track){
        if(track.size() == nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums,track);
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(permut(nums));
    }
}
