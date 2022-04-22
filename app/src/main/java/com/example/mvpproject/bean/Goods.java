package com.example.mvpproject.bean;

/**
 * Copyright 2022 bejson.com
 */
import java.util.List;

/**
 * Auto-generated: 2022-04-21 17:50:38
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Goods<T> {

    private T data;
    private int code;
    private String message;
    public void setData(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }

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

}