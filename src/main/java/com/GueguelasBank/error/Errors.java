package com.GueguelasBank.error;

public enum Errors {
    EMPTY_REGISTERS("No records found",404),
    USER_NOT_FOUND("User not found", 404),
    BANK_NOT_FOUND("Bank not found", 404),
    INTERNAL_SERVER_ERROR("Internal server error", 500),
    BAD_REQUEST("Bad request", 400);

    private final String message;
    private final Integer code;

    Errors(String message, int i) {
        this.message = message;
        this.code = i;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode(){
        return code;
    }
}
