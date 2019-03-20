package com.qch.pm.domain.util;

/**
 * @author : qiuchenhao
 * @date : 2019/3/16
 */
public enum ResponseCode {
    SUCCESS(0, "请求成功"),
    WARN(-1, "操作异常，请稍后重试");

    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
