package com.zadanie.zadanie2.helpers;

public class ApiResponse {

    public static enum Status{
        OK,
        ERROR
    }

    public static final class AppError{

        private final int errorCode;
        private final String description;

        public AppError(int errorCode, String description) {
            this.errorCode = errorCode;
            this.description = description;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public String getDescription() {
            return description;
        }
    }

    private final Status status;
    private final Object data;
    private final AppError error;

    public ApiResponse(Status status, Object data){
        this(status, data, null);
    }

    public ApiResponse(Status status, Object data, AppError error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public Status getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }

    public AppError getError() {
        return error;
    }
}
