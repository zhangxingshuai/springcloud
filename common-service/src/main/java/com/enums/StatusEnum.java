package com.enums;

public enum StatusEnum {
    success(200, "成功"),
    failure(500, "失败");

    private final int value;
    private final String name;

    StatusEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }
}
