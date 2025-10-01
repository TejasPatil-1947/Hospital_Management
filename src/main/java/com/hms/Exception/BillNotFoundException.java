package com.hms.Exception;

public class BillNotFoundException extends RuntimeException{
    public BillNotFoundException(String msg){
        super(msg);
    }
}
