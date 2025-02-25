package com.app.data.exceptions;

import java.util.HashMap;
import java.util.Map;

//valida os campos
public class ValidationExeception extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    private Map<String, String> errors = new HashMap<>();



    public ValidationExeception(String msg) {
        super(msg);
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String errorMessage) {
        errors.put(fieldName, errorMessage);
    }


}
