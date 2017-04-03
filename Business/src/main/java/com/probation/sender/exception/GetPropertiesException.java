package com.probation.sender.exception;


public class GetPropertiesException extends Exception
{
    private long code;

    public GetPropertiesException(long code, String message) {
        super(message);
        this.code = code;
    }

    public long getCode() {
        return code;
    }
}
