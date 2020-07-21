package com.power4j.kit.utils;

/**
 * @author CJ (jclazz@outlook.com)
 * @date 2020/6/14
 * @since 1.0
 */
public class R<T> {
    public final static int SUCCESS = 0;
    public final static int FAIL = -1;

    private Integer code;
    private String msg;
    private T data;

    public static <T> R<T> ok(T data){
        return new R<>(SUCCESS,null,data);
    }

    public static <T> R<T> fail(String msg){
        return new R<>(FAIL,msg,null);
    }

    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
