package it.amedei.exception;/*
@author Alessandro Amedei
2022    
*/

public enum RestErrorEnum {

    INVALID_CSV_FORMAT("E4002",400,"CSV Invalid format"),
    INVALID_DATE_FORMAT("E4003",400,"CSV Invalid date format"),
    USER_NOT_FOUND("E4001", 404, "User not found"),
    USER_WITH_SAME_EMAIL_ALREADY_EXISTS("E001", 418, "A user with this email already exists!"),
    USER_ID_IS_MANDATORY("E002", 418, "Id is mandatory to update the user");

    String code;
    Integer state;
    String message;

    RestErrorEnum(String code, Integer state, String message) {
        this.code = code;
        this.state = state;
        this.message = message;
    }


}
