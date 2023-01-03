package com.example.tutorial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestJOL {
    private static class T{

    }

    public static void main(String[] args) {
        T t = new T();
        //System.out.println(ClassLayout);
        List<Object> list = new ArrayList<>(5);
        list.add(null);
        list.add("1");
        for(Iterator var4 = list.iterator();var4.hasNext();){

        }
    }
}
