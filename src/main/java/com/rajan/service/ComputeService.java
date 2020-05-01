package com.rajan.service;

import com.rajan.representation.OperandsRepresentation;
import com.rajan.response.ResultResponse;
import org.springframework.stereotype.Service;

@Service
public class ComputeService {

    public ResultResponse add(OperandsRepresentation operands) {
        int x = Integer.parseInt(operands.getOp1());
        int y = Integer.parseInt(operands.getOp2());
        return new ResultResponse(x + y);
    }

    public ResultResponse diff(OperandsRepresentation operands) {
        int x = Integer.parseInt(operands.getOp1());
        int y = Integer.parseInt(operands.getOp2());
        return new ResultResponse(x - y);
    }

}
