package org.wahlzeit.Exceptions;

public class InvalidSphericRangeException extends Exception{

    public InvalidSphericRangeException(){
        super();
    }

    public InvalidSphericRangeException(String message){
        super(message);
    }

    public InvalidSphericRangeException(String message, Throwable cause){
        super(message, cause);
    }

    public InvalidSphericRangeException(Throwable cause){
        super(cause);
    }
}
