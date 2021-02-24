package com.DemoHTML1.demoHTML1.model.src.NewGame;

public class ErrorException extends RuntimeException {

    public ErrorException(String var1) {
        super(var1);
    }
    public ErrorException(Exception var1)
    {
        super(var1.getClass().getName() + ": " + var1.getMessage());
    }
}
