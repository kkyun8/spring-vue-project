package com.rest.api.exception;

public class COrderStatusNotFoundException extends RuntimeException {
    public COrderStatusNotFoundException(String msg, Throwable t){
        super(msg, t);
    }

    public COrderStatusNotFoundException(String msg) {
        super(msg);
    }

    public COrderStatusNotFoundException() {
        super();
    }
}
