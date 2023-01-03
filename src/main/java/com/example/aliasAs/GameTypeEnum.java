package com.example.aliasAs;

public enum GameTypeEnum {
    SLOT("S"),
    TABLE("T"),
    LOTTERY("L");
    private String type;

    private GameTypeEnum(String typeStr) {
        this.type = typeStr;
    }

    public String getType() {
        return this.type;
    }
}
