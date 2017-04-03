package com.probation.sender.exception;


public class DaoException extends Exception
{
    private long code;

    public DaoException (long code, String message) {
        super(message);
        this.code = code;
    }

    public long getCode() {
        return code;
    }
}
