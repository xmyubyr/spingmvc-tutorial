package com.jindian.chapter1;

//一次编辑。字符串有三种编辑操作：插入一个字符、删除一个字符或者替换一个字符。
//给定两个字符串，编写一个函数判定它们是否只需要一次（或者零次）编辑。
/*示例：
        pale, ple -> true
        pales, pale -> true
        pale, bale -> true
        pale, bake -> false*/
public class OneEdit05 {
    public static void main(String[] args) {
       System.out.println(oneEditAway("pal","pale"));
    }
    public static boolean oneEditAway(String first,String second){
        if(first.length() == second.length()){
            return oneEditReplace(first,second);
        }else if(first.length() == second.length()+1){
            return oneEditInsert(first,second);
        }else if(first.length() == second.length()-1){
            return oneEditInsert(second,first);
        }
        return false;
    }

    public static boolean oneEditReplace(String s1,String s2){
        boolean foundDifferent= false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!= s2.charAt(i)){
                if(foundDifferent){
                   return false;
                }
                foundDifferent =true;
            }
        }
        return true;
    }
    public static boolean oneEditInsert(String s1,String s2){
        int index1=0;
        int index2=0;
        while(index1<s1.length()&& index2<s2.length()){
            if(s1.charAt(index1)!= s2.charAt(index2)){
                if(index1 != index2){
                    return false;
                }
                index2++;
            }else{
                index1++;
                index2++;
            }
        }
        return true;
    }
}
