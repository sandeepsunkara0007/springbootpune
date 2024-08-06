package com.java.springbootproject2.error;

public class Departmentnotfound extends Exception{
    public Departmentnotfound() {
        super();
    }

    public Departmentnotfound(String message) {
        super(message);
    }

    public Departmentnotfound(String message, Throwable cause) {
        super(message, cause);
    }

    public Departmentnotfound(Throwable cause) {
        super(cause);
    }

    protected Departmentnotfound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
