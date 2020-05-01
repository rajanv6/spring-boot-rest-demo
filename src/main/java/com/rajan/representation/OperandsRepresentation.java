package com.rajan.representation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@NotNull
public class OperandsRepresentation {
    @JsonProperty("x")
    private final String op1;
    @JsonProperty("y")
    private final String op2;

    public OperandsRepresentation(String x, String y) {
        op1 = x;
        op2 = y;
    }

    public String getOp1() {
        return op1;
    }

    public String getOp2() {
        return op2;
    }

}
