package com.example.jindian.chapter8;

import java.util.ArrayList;
import java.util.List;

//括号。设计一种算法，打印n 对括号的所有合法的（例如，开闭一一对应）组合。
public class Parenthesis09 {
    static List<String> list = new ArrayList<>();
    static int n =2;
    public static List<String> generateParenthesis(){
        dfs(0,0,"");
        return list;
    }
    public static void dfs(int l,int r,String s){
        //l+ r == 2*n
        if(l==n && r == n){
            list.add(s);
            return;
        }
        if(r>l){
            return;
        }
        if(l<n){
            dfs(l+1,r,s+"(");
        }
        if(r<n){
            dfs(l,r+1,s+")");


        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis());
    }
}
