package com.example.knowledge_graph.util;

/**
 * 用于封装返回结果
 */
public class Result {

    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    private boolean result;
    private String msg;
    private Object data;

    private Result() {
    }

    public static Result ok() {
        return Result.ok(SUCCESS);
    }

    public static Result ok(String msg) {
        return Result.ok(msg, null);
    }

    public static Result ok(Object data) {
        return Result.ok(SUCCESS, data);
    }

    public static Result ok(String msg, Object datas) {
        Result result = new Result();
        result.setResult(true);
        result.setMsg(msg);
        result.setData(datas);
        return result;
    }

    public static Result fail() {
        return Result.fail(FAILURE);
    }

    public static Result fail(String msg) {
        return Result.fail(msg, null);
    }

    public static Result fail(Object data) {
        return Result.fail(FAILURE, data);
    }

    public static Result fail(String msg, Object datas) {
        Result result = new Result();
        result.setResult(false);
        result.setMsg(msg);
        result.setData(datas);
        return result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
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