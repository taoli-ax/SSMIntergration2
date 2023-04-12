package com.coh.controller;

public class Result {
    private Integer code;
    private Object data;
    private String message;


    public Result() {
    }

    public Result(Integer code,Object data) {
        this.data = data;
        this.code = code;
    }

    public Result(Integer code,Object data, String message) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
