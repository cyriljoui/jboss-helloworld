package com.cjo.jee.controllers.model;

/**
 * Created by popom on 15/10/2016.
 */
public class Error {

    private String errorCode;

    private String message;

    public Error() {
    }

    public Error(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
