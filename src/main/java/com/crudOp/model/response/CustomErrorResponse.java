package com.crudOp.model.response;

public class CustomErrorResponse {
    public int getStatusCode() {
        return statusCode;
    }

    public CustomErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    int statusCode;
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
