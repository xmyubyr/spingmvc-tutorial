package com.example.jindian.chapter5;

public class BinaryToString02 {
    public static void main(String[] args) {
        System.out.println(printBinary(0.1));//ERROR
        System.out.println(printBinary(0.625));//0.101
    }
    public static String printBinary(double num){
        if(num >1 || num <0){
            return "ERROR";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0.");
        while(num >0){
           if (stringBuilder.length() >=32){
                return "ERROR";
            }
            double r = num *2;
            if(r>=1){
                num = r-1.0;
                stringBuilder.append(1);
            }else{
                stringBuilder.append(0);
                num = r;
            }
        }
        return stringBuilder.toString();
    }
}
