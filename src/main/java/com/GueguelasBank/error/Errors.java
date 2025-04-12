package com.GueguelasBank.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Errors {
    EMPTY_REGISTERS("No records found",404),
    USER_NOT_FOUND("User not found", 404),
    BANK_NOT_FOUND("Bank not found", 404),
    MORE_THEN_ZERO("The number of records must be greater than 0", 400);

    private final String message;
    private final Integer code;

}
