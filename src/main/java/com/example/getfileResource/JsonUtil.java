package com.example.getfileResource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonUtil {
    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        //mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    public static JsonNode stringToJSONNode(String payload){
        JsonNode node = null;
        try {
            node = mapper.readTree(payload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return node;
    }
    public static <T> T getValueInJSONNode(JsonNode parent, String childNode, Class<T> value){
        T result = null;
        if(null != parent){
            if(value == String.class){
                JsonNode jsonNode = parent.get(childNode);
                if(jsonNode != null && !jsonNode.isNull()){
                    result = (T)parent.get(childNode).asText();
                }

            }
            // add other type
        }
        return result;
    }
    public static void removeFieldInJSONNode(JsonNode parent,String childNode){

        if(null != parent){
            ((ObjectNode)parent).remove(childNode);
        }
    }

    public static void addFieldInJSONNode(JsonNode parent,String childNode,JsonNode payload){

        if(null != parent){
            ((ObjectNode)parent).set(childNode,payload);
        }
    }
    public static JsonNode ObjectToJSONNode(Object obj){
        JsonNode node = null;
        node = mapper.convertValue(obj,JsonNode.class);
        return node;
    }
    public static String covertObjectToString(Object obj){
        String s = null;
        try {
            s = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

}
