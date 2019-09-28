package com.ssq.mvp.bean;

import java.util.List;

/**
 * Author : Mr.Shen
 * Date : 2019/9/28 11:24
 * Description : 数组
 */
public class BaseArrayBean<T> {

    private int errorCode;
    private String errorMsg;
    private List<T> result;

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public List<T> getResult() {
        return result;
    }
}
