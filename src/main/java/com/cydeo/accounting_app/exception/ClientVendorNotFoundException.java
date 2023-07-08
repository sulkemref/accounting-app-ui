package com.cydeo.accounting_app.exception;

public class ClientVendorNotFoundException extends RuntimeException{
    public ClientVendorNotFoundException(String message) {
        super(message);
    }

    public ClientVendorNotFoundException(String message, Throwable err) {
        super(message, err);
    }
}
