package com.example.tutorial;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestJson {
    public static void main(String[] args) throws JsonProcessingException {
        /*String payload ="{\"skincode\":\"ISB3\",\"ipaddress\":\"212.183.128.90\",\"forcelat\":\"53.481111\",\"minbet\":\"0.01\",\"forcelocationstatus\":\"0\",\"countrycode\":\"GB\",\"nscode\":\"ISB\",\"language\":\"en\",\"technology\":\"HTML\",\"currencycode\":\"GBP\",\"loadskin\":\"MXF\",\"forcelng\":\"-2.1025\",\"securetoken\":\"3322.436385.ISH\",\"softwareid\":\"502-0026-101\",\"denomamount\":\"0.01\",\"presenttype\":\"STD\",\"forcelocationmessage\":\"-SUCCESS\",\"uniqueid\":\"mini005\",\"fetchmode\":\"full\"}";
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> parms = mapper.readValue(payload, HashMap.class);
        Iterator<Map.Entry<String,String>> it = parms.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,String> map= it.next();
            System.out.println(map.getKey()+":"+map.getValue());
        }*/
        String payload = "skincode=S472&countrycode=GB&nscode=IPA2&language=en&currencycode=GBP&softwareid=502-0026-101&ipaddress=212.183.128.90&forcelat=53.481111&minbet=0.01&forcelocationstatus=0&technology=HTML&loadskin=MXF&forcelng=-2.1025&securetoken=3343.436385.ISH&denomamount=0.01&presenttype=STD&forcelocationmessage=-SUCCESS&uniqueid=mini005&ts=1658999991396";
        if(payload.contains("&")){
            String[] payloadArray = payload.split("&");
            Map<String,String> parms = new HashMap<>();
            for(String s:payloadArray){
                // parms.put(s);
                String[] parm = s.split("=");
                parms.put(parm[0],parm[1]);
            }
            Iterator<Map.Entry<String,String>> it = parms.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<String,String> map= it.next();
                System.out.println(map.getKey()+":"+map.getValue());
            }
        }


    }
}
