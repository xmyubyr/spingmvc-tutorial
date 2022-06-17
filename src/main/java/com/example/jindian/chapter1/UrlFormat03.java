package com.jindian.chapter1;
//URL 化。编写一种方法，将字符串中的空格全部替换为 %20。假定该字符串尾部有足够
//的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java 实现的话，请使
//用字符数组实现，以便直接在数组上操作。）
//示例：
//输入："Mr John Smith ", 13
//输出："Mr%20John%20Smith"
//（提示：#53，#118）
public class UrlFormat03 {
    public static void main(String[] args) {
        System.out.println(format("Mr John Smith               ".toCharArray(),13));
    }
    public static String format(char[] s,int l){

        int space=0;
        for(int i=0;i<l;i++){
            if(s[i] ==' '){
                space++;
            }
        }
        int index = l+space*2;
        /*if(l<s.length){
          s[l]='\0';
        }*/
        for(int i=l-1;i>=0;i--){
            if(s[i]==' '){
               s[index -1]='0';
               s[index -2]='2';
               s[index -3]='%';
               index = index -3;
            }else{
                s[index-1]=s[i];
                index --;
            }
        }
        return new String(s);
    }
}
