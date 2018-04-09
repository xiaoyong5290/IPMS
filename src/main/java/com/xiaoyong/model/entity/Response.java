package com.xiaoyong.model.entity;

/**
 * @author : XiaoYong
 * @date : 2018/3/28 16:20
 * Description    :
 */
@SuppressWarnings("unused")
public class Response {
    private int code;
    private String message;

    public static final Response SUCCESS = new Response(0,"success");
    public static final Response ERROR = new Response(1,"error");

    public Response() {
    }

    private Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
