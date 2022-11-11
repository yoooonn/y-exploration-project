package com.ycourlee.explore.jmhjavabench.support;

/**
 * @author yooonn
 * @date 2021.01.23
 */
public enum BelTypeEnum {

    INTEGER("integer"),
    LONG("long"),
    DOUBLE("double"),
    STRING("string"),
    OBJECT("Object"),
    TIMESTAMP_LONG("timestamp long"),
    TIMESTAMP_STRING("timestamp string"),
    NOW_STRING("new Date 'format'"),
    EMPTY_ARRAY("new JSONArray"),
    EMPTY_OBJECT("new JSONObject"),
    ;

    private final String name;

    BelTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
