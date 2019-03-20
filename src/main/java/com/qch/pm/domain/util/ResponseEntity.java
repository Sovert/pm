package com.qch.pm.domain.util;

/**
 * @author : qiuchenhao
 * @date : 2019/3/16
 */
import javax.xml.ws.Response;

public class ResponseEntity {

    private int code;
    private String msg;
    private Object data;

    public ResponseEntity(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }

    public ResponseEntity(ResponseCode responseCode, Object data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
