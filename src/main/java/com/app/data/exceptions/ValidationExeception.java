package com.app.data.exceptions;

public class ValidationExeception extends RuntimeException {
    private static final long serialVersionUID = 1L;



    public ValidationExeception(String msg) {
        super(msg);
    }

}
