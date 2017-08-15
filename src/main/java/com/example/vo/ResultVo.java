package com.example.vo;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-07-20 下午11:11
 */
public class ResultVo {
    private String result;
    private Integer code;


    public ResultVo() {
    }

    public ResultVo(String result, Integer code) {
        this.result = result;
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "result='" + result + '\'' +
                ", code=" + code +
                '}';
    }
}
