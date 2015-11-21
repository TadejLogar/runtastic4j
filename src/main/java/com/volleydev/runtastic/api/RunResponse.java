package com.volleydev.runtastic.api;

/**
 * Created by flonussi on 11/21/15.
 */
public class RunResponse {

    private int statusCode;

    private String responseBody;

    public RunResponse(int statusCode, String responseBody) {
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }
}
