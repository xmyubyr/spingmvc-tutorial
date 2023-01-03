package com.example.tutorial;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("key1","v1");
        map.put("key2","v2");
        map.put("key3","v3");
        map.put("key4","v4");
        map.put("key5","v5");
        System.out.println(map);
    }
}
