package com.example.jindian.chapter3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String regEx = "[2-9]0[0-9]-[0-9]{4}-[0-9]{3}";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher("502-0026-101");
        if(matcher.find()){
            System.out.println("right");
        }else{
            System.out.println("no");
        }
    }

}
