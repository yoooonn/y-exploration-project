package com.ycourlee.explore.springredis.service;

/**
 * @author yooonn
 * @date 2022.02.07
 */
public class LuaScripts {

    public static final String Z_POP_MIN = "return redis.call('zPopMin', KEYS[1], ARGV[1])";

    public static final String Z_INCR_BY_TEMPLATE = "redis.call('zIncrBy', KEYS[%s], ARGV[2], KEYS[1]);";

    public static final String DRIVER_SEAT_INCR   = "local score = redis.call('zScore', KEYS[2], KEYS[1]); local retCode = 0;" +
            "if score + ARGV[1] < 0 then retCode = -1 else retCode = redis.call('zIncrBy', KEYS[2], ARGV[1], KEYS[1]) end;";
    public static final String DRIVER_SEAT_RETURN = "return retCode;";
}
