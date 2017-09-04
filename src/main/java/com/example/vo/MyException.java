package com.example.vo;

/**
 * Created by lidongliang on 2017/9/4.
 */
public class MyException extends RuntimeException {
    String msg;
    String code;

    public MyException(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public MyException(String msg) {
        this.msg = msg;
    }

    public MyException(Throwable cause, String msg) {
        super(cause);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }


    public String getCode() {
        return code;
    }


}
