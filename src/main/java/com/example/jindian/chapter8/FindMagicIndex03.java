package com.example.jindian.chapter8;
//魔术索引。在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一
//个有序整数数组，元素值各不相同，编写一种方法找出魔术索引，若有的话，在数组A 中找出
//一个魔术索引。
//进阶：如果数组元素有重复值，又该如何处理呢？
public class FindMagicIndex03 {
    public static int findMagicIndex(int[] a){
        return binarySearch(0,a.length-1,a);
    }
    public static int binarySearch(int l,int r,int[] a){
        if(l>r){
           return -1;
        }
        int mid = (l+r)>>1;
        l=binarySearch(l,mid-1,a);
        if(l!=-1){
           return l;
        } else if(a[mid] == mid){
            return mid;
        }else{
            return binarySearch(mid+1,r,a);
        }
    }

    public static void main(String[] args) {
        int a[] = {1,1,1};
        System.out.println(findMagicIndex(a));
    }
}
