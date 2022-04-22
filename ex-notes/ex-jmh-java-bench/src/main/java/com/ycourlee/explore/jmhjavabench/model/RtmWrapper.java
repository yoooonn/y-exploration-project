package com.ycourlee.explore.jmhjavabench.model;

import com.ycourlee.tranquil.web.ApiCode;
import com.ycourlee.tranquil.web.CodeMessage;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author yongjiang
 * @date 2021.03.31
 */
public class RtmWrapper extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public static final String CODE = "code";
    public static final String MSG  = "msg";
    public static final String DATA = "data";

    private RtmWrapper() {
    }

    private RtmWrapper(Integer code, String msg, Object data) {
        super.put(CODE, code);
        super.put(MSG, msg);
        if (Objects.nonNull(data)) {
            super.put(DATA, data);
        }
    }

    private RtmWrapper(CodeMessage CodeMessage, Object data) {
        this(CodeMessage.getCode(), CodeMessage.getMsg(), data);
    }

    @Override
    public RtmWrapper put(String key, Object data) {
        super.put(key, data);
        return this;
    }

    public RtmWrapper pin(String key, Object data) {
        return put(key, data);
    }

    public RtmWrapper code(Object code) {
        return put(CODE, code);
    }

    public RtmWrapper msg(Object msg) {
        return put(MSG, msg);
    }

    public RtmWrapper data(Object data) {
        return put(DATA, data);
    }

    public static RtmWrapper blanker() {
        return new RtmWrapper();
    }

    public static RtmWrapper success() {
        return new RtmWrapper(ApiCode.SUCCESS.getCode(), ApiCode.SUCCESS.getMsg(), null);
    }

    public static RtmWrapper success(Object data) {
        return new RtmWrapper(ApiCode.SUCCESS.getCode(), ApiCode.SUCCESS.getMsg(), data);
    }

    public static RtmWrapper success(Integer code, String msg, Object data) {
        return new RtmWrapper(code, msg, data);
    }

    public static RtmWrapper error() {
        return new RtmWrapper(ApiCode.ERROR.getCode(), ApiCode.ERROR.getMsg(), null);
    }

    public static RtmWrapper error(CodeMessage em) {
        return new RtmWrapper(em.getCode(), em.getMsg(), null);
    }

    public static RtmWrapper error(Integer code, String msg, Object data) {
        return new RtmWrapper(code, msg, data);
    }
}
