package com.pancm.model;


import java.util.ArrayList;
import java.util.List;

public class RespBody<T> {
    /**
     * 自定义业务码
     */
    private String code;
    /**
     * 自定义业务提示说明
     */
    private String message;
    /**
     * 自定义返回 数据结果集
     */
    private T respBody;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getRespBody() {
        return respBody;
    }

    public void setRespBody(T respBody) {
        this.respBody = respBody;
    }

    public RespBody() {

    }

    public RespBody(String code) {
        this.code = code;
    }

    public RespBody(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public RespBody(String code, String message, T respBody) {
        this.code = code;
        this.message = message;
        this.respBody = respBody;
    }

    public static RespBody<Void> ok() {
        return ok(null);
    }

    public static <T> RespBody<T> ok(T body) {
        return build(RespCode.OK, body);
    }

    //各种错误信息的返回
    public static RespBody<List<Object>> list(ResultCode resultCode, String msg) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(msg);
        list.add(0);
        return build(resultCode, list);
    }

    public static RespBody<Void> expired() {
        return expired(null);
    }

    public static <T> RespBody<T> expired(T body) {
        return build(RespCode.UNAUTHORIZED, body);
    }

    public static RespBody<ErrorBody> error(String code, String message, ErrorBody errorBody) {
        return build(code, message, errorBody);
    }

    public static RespBody<ErrorBody> error(ResultCode resultCode, ErrorBody errorBody) {
        return build(resultCode.getCode(), resultCode.getMessage(), errorBody);
    }

    public static RespBody<ErrorBody> error(ResultCode resultCode, String message, ErrorBody errorBody) {
        return build(resultCode.getCode(), message, errorBody);
    }


    public static <T> RespBody<T> fail(String message) {
        return fail(RespCode.FAIL, message, null);
    }

    public static <T> RespBody<T> fail(ResultCode resultCode) {
        return fail(resultCode, resultCode.getMessage(), null);
    }

    public static <T> RespBody<T> fail(ResultCode resultCode, String message, T data) {
        return build(resultCode.getCode(), message, data);
    }


    public static <T> RespBody<T> build(ResultCode resultCode, T body) {
        return build(resultCode.getCode(), resultCode.getMessage(), body);
    }

    /**
     * 以上所有构建均调用此底层方法
     *
     * @param stateCode 状态值
     * @param message   返回消息
     * @param body      返回数据体
     */
    public static <T> RespBody<T> build(String stateCode, String message, T body) {
        return new RespBody<>(stateCode, message, body);
    }

}
