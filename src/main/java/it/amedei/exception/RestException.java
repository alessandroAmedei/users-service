package it.amedei.exception;/*
@author Alessandro Amedei
Net Studio S.p.A
2022    
*/

public class RestException extends Exception {

    private Integer state;
    private String message;
    private String code;

    public RestException(RestErrorEnum restErrorEnum) {
        this.state = restErrorEnum.state;
        this.message = restErrorEnum.message;
        this.code = restErrorEnum.code;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
