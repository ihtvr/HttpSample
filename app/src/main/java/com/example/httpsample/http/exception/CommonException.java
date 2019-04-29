package com.example.httpsample.http.exception;

/**
 * 自定义错误信息
 */
public class CommonException extends Exception {
    private String errMsg;
    public CommonException(){

    }

    public CommonException(String errMsg){
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
