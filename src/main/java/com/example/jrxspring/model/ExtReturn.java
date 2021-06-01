package com.example.jrxspring.model;

import java.sql.Date;

public class ExtReturn {
    public ExtReturn(boolean success, Object object, String errorTip) {
        this.success = success;
        this.object = object;
        this.errorTip = errorTip;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getErrorTip() {
        return errorTip;
    }

    public void setErrorTip(String errorTip) {
        this.errorTip = errorTip;
    }

    private boolean success;
    private Object object;
    private String errorTip;

}
