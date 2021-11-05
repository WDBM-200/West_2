package com.cxq.two;

public class InsufficientBalanceException extends BaseException{
    public InsufficientBalanceException() {
        super();
    }
    public InsufficientBalanceException(String message) {
        super(message);
    }

}
