package com.rajan.rest;

import com.rajan.representation.OperandsRepresentation;
import com.rajan.response.ResultResponse;
import com.rajan.service.ComputeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class OperationController {

    private final ComputeService computeService;

    public OperationController(ComputeService computeService) {
        this.computeService = computeService;
    }

    @PostMapping("/add")
    public ResponseEntity<ResultResponse> add(@RequestBody OperandsRepresentation operands) {
        if (null == operands.getOp1() && null == operands.getOp2()
            || null == operands.getOp1()
            || null == operands.getOp2()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid input format");
        }
        return ResponseEntity.ok(computeService.add(operands));
    }

    @PostMapping("/diff")
    public ResponseEntity<ResultResponse> diff(@RequestBody OperandsRepresentation operands) {
        if (null == operands.getOp1() && null == operands.getOp2()
                || null == operands.getOp1()
                || null == operands.getOp2()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid input format");
        }
        return ResponseEntity.ok(computeService.diff(operands));
    }
}
