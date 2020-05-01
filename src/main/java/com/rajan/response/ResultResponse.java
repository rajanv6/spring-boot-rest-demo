package com.rajan.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultResponse {
    @JsonProperty
    private int result;

    public ResultResponse() {
        super();
    }

    public ResultResponse(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
