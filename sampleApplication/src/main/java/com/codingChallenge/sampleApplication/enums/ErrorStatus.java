package com.codingChallenge.sampleApplication.enums;

public enum ErrorStatus {
    DATA_NOT_FOUND("Data not found"),
    USER_UPDATE_ERROR("User could not updated"),
    USER_DELETE_ERROR("User could not be deleted"),
    PASSWORD_ERROR("Missing password"),
    EMAIL_ERROR("Missing email"),
    USER_CREATE_ERROR("User could not created");
    private final String errMsg;

    ErrorStatus(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrorMessage() {
        return errMsg;
    }
}
