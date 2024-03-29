package com.ayy.xframe.base;

public class BaseResponse<T> {
    private int errorCode;
    private String errorMsg;
    private T data;

    public boolean isSuccess() {
        return errorCode == 0;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
