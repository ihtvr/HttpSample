package com.example.httpsample.bean;


/**
 * 服务器统一返回值
 *
 * @param <T>
 */
public class BaseResponse<T> {

    public static final int SUCCESS = 0;
    public static final int FAIL = 1;

    /**
     * data : ...
     * errorCode : 0
     * errorMsg :
     */

    private T data;
    private int errorCode;
    private String errorMsg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
