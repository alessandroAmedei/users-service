package it.amedei.exception;/*
@author Alessandro Amedei
2022    
*/

import java.io.Serializable;

public class RestResponse implements Serializable {
    String code;
    String message;
    String from;

    public RestResponse(String code, String message, String from) {
        this.code = code;
        this.message = message;
        this.from = from;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}