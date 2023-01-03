package com.example.aliasAs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateMapKey {
    public static void main(String[] args) {
        ServerConfig serverConfig = new ServerConfig();
        Map<String, Object> autoSpinV3 = new HashMap<String, Object>();
        List<Integer> lossLimit = new ArrayList<>();
        List<Integer> winLimit = new ArrayList<>();
        lossLimit.add(2);
        lossLimit.add(5);
        lossLimit.add(10);
        lossLimit.add(15);
        lossLimit.add(25);
        winLimit.add(3);
        winLimit.add(10);
        winLimit.add(15);
        winLimit.add(20);
        winLimit.add(30);
        autoSpinV3.put("S_steps",5);
        autoSpinV3.put("S_lossLimit",lossLimit);
        autoSpinV3.put("S_winLimit",winLimit);
        autoSpinV3.put("S_version",2);
        serverConfig.setAutospin(autoSpinV3);
        System.out.println(serverConfig.getAutospin());
        Map<String, Object> target =removePre(serverConfig.getAutospin());
        serverConfig.setAutospin(target);
        System.out.println(serverConfig.getAutospin());
        GameTypeEnum gameTypeEnum = GameTypeEnum.LOTTERY;
        System.out.println(gameTypeEnum.getType());

    }
    public static Map<String, Object>  removePre(Map<String, Object> autoSpinV3){
        Map<String, Object> target = new HashMap<String, Object>();
        autoSpinV3.forEach((key,value)->{
            if (key.startsWith("S_")){
                /*String targetK = key.replace("S_","");*/
                String targetK =key.substring(2);
                target.put(targetK,value);
            }
        });
        return target;
    }
}
