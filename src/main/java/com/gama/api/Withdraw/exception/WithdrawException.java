package com.gama.api.Withdraw.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WithdrawException extends RuntimeException {
    public WithdrawException(){
        super("Withdraw cannot be completed with an invalid value");
    }
}
