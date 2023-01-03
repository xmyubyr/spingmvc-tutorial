package com.example.jindian.chapter6;

public class PrimNative {
    public boolean isPrimeNative(int num){
        if(num <2){
            return false;
        }
        for(int i=2;i< (int)Math.sqrt(num);i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
