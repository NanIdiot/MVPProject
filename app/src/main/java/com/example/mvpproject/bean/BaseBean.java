package com.example.mvpproject.bean;

/**
 * Copyright 2022 bejson.com
 */
import java.util.List;

/**
 * Auto-generated: 2022-04-21 16:29:34
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BaseBean<T> {

    private int code;
    private String message;
    private T data;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setData(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }

}